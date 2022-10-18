package ar.com.utn.frc.msi.tpi.vipFarmaBackEnd.services.impl;

import ar.com.utn.frc.msi.tpi.vipFarmaBackEnd.entity.BranchOfficeEntity;
import ar.com.utn.frc.msi.tpi.vipFarmaBackEnd.entity.SaleOrderEntity;
import ar.com.utn.frc.msi.tpi.vipFarmaBackEnd.model.sale.SaleOrder;
import ar.com.utn.frc.msi.tpi.vipFarmaBackEnd.model.sale.SaleOrderItem;
import ar.com.utn.frc.msi.tpi.vipFarmaBackEnd.model.sale.SaleOrderStatus;
import ar.com.utn.frc.msi.tpi.vipFarmaBackEnd.model.stock.Stock;
import ar.com.utn.frc.msi.tpi.vipFarmaBackEnd.repositories.SaleOrderRepository;
import ar.com.utn.frc.msi.tpi.vipFarmaBackEnd.services.SaleOrderItemService;
import ar.com.utn.frc.msi.tpi.vipFarmaBackEnd.services.SaleOrderService;
import ar.com.utn.frc.msi.tpi.vipFarmaBackEnd.services.UserService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class SaleOrderServiceImpl extends BaseModelServiceImpl<SaleOrder, SaleOrderEntity> implements SaleOrderService {

    private final UserService userService;

    private final SaleOrderItemService saleOrderItemService;

    private final SaleOrderRepository saleOrderRepository;

    private final ModelMapper modelMapper;

    @Override
    protected JpaRepository getJpaRepository() {
        return this.saleOrderRepository;
    }

    @Override
    protected ModelMapper getModelMapper() {
        return this.modelMapper;
    }

    @Override
    public SaleOrder create(SaleOrder saleOrder) {

        // Set status to CREATED, creation date and save Order
        saleOrder.setSaleOrderStatus(SaleOrderStatus.CREATED);
        saleOrder.setCreatedDate(LocalDate.now());
        SaleOrder savedOrder = super.create(saleOrder);

        // Set orderId in each items and save items
        List<SaleOrderItem> itemsToSave = saleOrder.getSaleOrderItems();
        for(SaleOrderItem item : itemsToSave) {
            item.setOrderId(savedOrder.getId());
        }
        List<SaleOrderItem> savedItems = saleOrderItemService.createAll(itemsToSave);

        // Set itemsSaved into order saved
        savedOrder.setSaleOrderItems(savedItems);

        // Calculate total Amount Order
        savedOrder.setTotalAmount(this.getTotalOrder(savedItems));

        return savedOrder;
    }

    @Override
    public List<SaleOrder> getOrdersByStatusAndBranchOffice(SaleOrderStatus saleOrderStatus, Long branchOfficeId) {
        BranchOfficeEntity branchOfficeEntity = new BranchOfficeEntity();
        branchOfficeEntity.setId(branchOfficeId);
        List<SaleOrderEntity> ordersList = saleOrderRepository.getBySaleOrderStatusAndBranchOfficeId(saleOrderStatus, branchOfficeEntity);
        return ordersList.stream()
                .map(entity -> getModelMapper().map(entity, SaleOrder.class))
                .collect(Collectors.toList());
    }

    @Override
    public SaleOrder changeStatus(Long id, SaleOrderStatus saleOrderStatus) {
        SaleOrder saleOrder = this.getById(id);
        saleOrder.setSaleOrderStatus(saleOrderStatus);
        saleOrder = this.update(saleOrder);
        return saleOrder;
    }

    private BigDecimal getTotalOrder(List<SaleOrderItem> items) {
        BigDecimal totalAmount = BigDecimal.ZERO;
        for(SaleOrderItem item : items) {
            totalAmount.add(getTotalItem(item));
        }
        return totalAmount;
    }

    private BigDecimal getTotalItem(SaleOrderItem item) {
        BigDecimal subTotal = getSubTotalItem(item.getUnitaryPrice(), item.getQuantity());
        return subTotal.subtract(item.getDiscountAmount());
    }

    private BigDecimal getSubTotalItem(BigDecimal price, Integer quantity) {
        return price.multiply(BigDecimal.valueOf(quantity));
    }
}
