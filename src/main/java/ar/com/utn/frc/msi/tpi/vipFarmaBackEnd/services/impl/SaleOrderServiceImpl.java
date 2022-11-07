package ar.com.utn.frc.msi.tpi.vipFarmaBackEnd.services.impl;

import ar.com.utn.frc.msi.tpi.vipFarmaBackEnd.entity.BranchOfficeEntity;
import ar.com.utn.frc.msi.tpi.vipFarmaBackEnd.entity.SaleOrderEntity;
import ar.com.utn.frc.msi.tpi.vipFarmaBackEnd.model.catalog.Product;
import ar.com.utn.frc.msi.tpi.vipFarmaBackEnd.model.sale.SaleOrder;
import ar.com.utn.frc.msi.tpi.vipFarmaBackEnd.model.sale.SaleOrderItem;
import ar.com.utn.frc.msi.tpi.vipFarmaBackEnd.model.sale.SaleOrderStatus;
import ar.com.utn.frc.msi.tpi.vipFarmaBackEnd.model.stock.Stock;
import ar.com.utn.frc.msi.tpi.vipFarmaBackEnd.repositories.SaleOrderRepository;
import ar.com.utn.frc.msi.tpi.vipFarmaBackEnd.services.SaleOrderItemService;
import ar.com.utn.frc.msi.tpi.vipFarmaBackEnd.services.SaleOrderService;
import ar.com.utn.frc.msi.tpi.vipFarmaBackEnd.services.StockService;
import ar.com.utn.frc.msi.tpi.vipFarmaBackEnd.services.UserService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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

    private final StockService stockService;

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
    @Transactional
    public SaleOrder create(SaleOrder saleOrder) {

        // Set status to CREATED, creation date and save Order
        saleOrder.setSaleOrderStatus(SaleOrderStatus.CREATED);
        saleOrder.setCreatedDate(LocalDate.now());
        SaleOrder savedOrder = super.create(saleOrder);

        // Set orderId in each items and save items
        if(saleOrder.getSaleOrderItems() != null && !saleOrder.getSaleOrderItems().isEmpty()) {
            List<SaleOrderItem> savedItems = saveSaleOrderItems(
                    saleOrder.getSaleOrderItems(),
                    savedOrder.getId(),
                    saleOrder.getBranchOffice().getId());
            // Set itemsSaved into order saved
            savedOrder.setSaleOrderItems(savedItems);
            // Calculate total Amount Order
            savedOrder.setTotalAmount(this.getTotalOrder(savedItems));
            savedOrder.setSaleOrderStatus(SaleOrderStatus.READY_TO_BILL);
            this.update(savedOrder);
        }

        return savedOrder;
    }


    private List<SaleOrderItem> saveSaleOrderItems(List<SaleOrderItem> saleOrderItems, Long savedOrderId, Long branchOfficeId) {
        for(SaleOrderItem item : saleOrderItems) {
            item.setOrderId(savedOrderId);
            Product product = item.getOffer().getProduct();
            List<Stock> stocks = stockService.reserveStock(product.getId(), branchOfficeId, item.getQuantity());
            item.setStocks(stocks);
            item.setDiscountAmount(this.getDiscountItem(item));
        }
        List<SaleOrderItem> savedItems = saleOrderItemService.createAll(saleOrderItems);
        return savedItems;
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
        if(saleOrderStatus == SaleOrderStatus.DELIVERED && saleOrder.getSaleOrderStatus() == SaleOrderStatus.BILLED) {
            saleOrder.getSaleOrderItems().forEach(
                    item -> {
                        List<Stock> stocks = stockService.getAllByIds(
                                item.getStocks().stream().map(stock -> stock.getId())
                                        .collect(Collectors.toList()));
                        stockService.inactivateStocks(stocks);
                    });
        }
        saleOrder.setSaleOrderStatus(saleOrderStatus);
        saleOrder = this.update(saleOrder);
        return saleOrder;
    }

    private BigDecimal getTotalOrder(List<SaleOrderItem> items) {
        BigDecimal totalAmount = BigDecimal.ZERO;
        for(SaleOrderItem item : items) {
            totalAmount = totalAmount.add(getTotalItem(item));
        }
        return totalAmount;
    }

    private BigDecimal getTotalItem(SaleOrderItem item) {
        BigDecimal subTotal = getSubTotalItem(item.getUnitaryPrice(), item.getQuantity());
        if(item.getDiscountAmount() != null) {
            return subTotal.subtract(item.getDiscountAmount());
        } else {
            return subTotal;
        }

    }

    private BigDecimal getSubTotalItem(BigDecimal price, Integer quantity) {
        if(price != null && quantity!= null) {
            return price.multiply(BigDecimal.valueOf(quantity));
        } else {
            return price;
        }
    }

    private BigDecimal getDiscountItem(SaleOrderItem item) {
        if(item.getDiscountAmount() != null) {
            BigDecimal totalDiscount = item.getDiscountAmount().multiply(BigDecimal.valueOf(item.getQuantity()));
            return totalDiscount;
        } else {
            return BigDecimal.ZERO;
        }
    }
}
