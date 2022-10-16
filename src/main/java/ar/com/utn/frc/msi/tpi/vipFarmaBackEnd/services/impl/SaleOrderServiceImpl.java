package ar.com.utn.frc.msi.tpi.vipFarmaBackEnd.services.impl;

import ar.com.utn.frc.msi.tpi.vipFarmaBackEnd.entity.OrderItemEntity;
import ar.com.utn.frc.msi.tpi.vipFarmaBackEnd.entity.SaleOrderEntity;
import ar.com.utn.frc.msi.tpi.vipFarmaBackEnd.model.sale.OrderItem;
import ar.com.utn.frc.msi.tpi.vipFarmaBackEnd.model.sale.SaleOrder;
import ar.com.utn.frc.msi.tpi.vipFarmaBackEnd.model.sale.SaleOrderStatus;
import ar.com.utn.frc.msi.tpi.vipFarmaBackEnd.repositories.SaleOrderRepository;
import ar.com.utn.frc.msi.tpi.vipFarmaBackEnd.services.SaleOrderService;
import ar.com.utn.frc.msi.tpi.vipFarmaBackEnd.services.UserService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.LinkedList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class SaleOrderServiceImpl implements SaleOrderService {

    //private UserService userService;
    //esto lo pusiste vos Hernán, no va acá

    private final SaleOrderRepository saleOrderRepository;
    private final ModelMapper modelMapper;

    @Override
    public SaleOrder createOrder(SaleOrder saleOrder) {

        SaleOrderEntity saleOrderEntity = getOrderToSave(saleOrder);

        // Insert orden
        List<OrderItemEntity> orderItemEntityList =
                getItemsToSave(saleOrder.getOrderItems(),
                        saleOrderEntity.getId());
        // Insert items

        // Set items en orden

        List<OrderItem> items = saleOrder.getOrderItems();
        BigDecimal totalAmount = getTotalOrder(items);
        saleOrder.setTotalAmount(totalAmount);
        // return orden
        return null;
    }

    @Override
    public List<SaleOrder> getOrders(String saleOrderStatus, Long branchOfficeId) {
        List<SaleOrderEntity> ordersList = saleOrderRepository.getBySaleOrderStatusAndBranchOfficeId(saleOrderStatus, branchOfficeId);


        return null;
    }

    @Override
    public SaleOrder changeStatus(Long id, String saleOrderStatus) {
        SaleOrderEntity saleOrderEntity = saleOrderRepository.getByIdAndSaleOrderStatus(id, saleOrderStatus);
        if (saleOrderEntity != null){
            //TODO me quedé trabado acá //saleOrderEntity.setSaleOrderStatus();
            return modelMapper.map(saleOrderEntity, SaleOrder.class);
        }
        throw new EntityNotFoundException("Orden no encontrada");
    }

    @Override
    public SaleOrder changeOrder(Long id, SaleOrder saleOrder) {
        return null;
    }

    @Override
    public SaleOrder getOrder(Long id) {
        SaleOrderEntity saleOrderEntity = saleOrderRepository.getReferenceById(id);
        if (saleOrderEntity == null) {
            throw new EntityNotFoundException(String.format("SaleOrder id {} not found", id));
        } else {
            return modelMapper.map(saleOrderEntity, SaleOrder.class);
        }
    }

    private SaleOrderEntity getOrderToSave(SaleOrder saleOrder) {
        SaleOrderEntity saleOrderEntity = new SaleOrderEntity();
        saleOrderEntity.setUserId(saleOrder.getUser().getId());
        saleOrderEntity.setCustomerId(saleOrder.getCustomer().getId());
        saleOrderEntity.setBranchOfficeId(saleOrder.getUser().getBranchOffice().getId());
        saleOrderEntity.setCreatedDate(LocalDate.now());
        saleOrderEntity.setSaleOrderStatus(SaleOrderStatus.CREATED.name());
        saleOrderEntity.setStatusDetail(saleOrder.getStatusDetail());
        return saleOrderEntity;
    }

    private List<OrderItemEntity> getItemsToSave(List<OrderItem> orderItems, Long id) {
        List<OrderItemEntity> orderItemEntityList = new LinkedList<>();

        for (OrderItem orderItem : orderItems) {
            OrderItemEntity orderItemEntity = new OrderItemEntity();
            orderItemEntity.setOrderId(id);
            orderItemEntity.setProductId(orderItem.getProduct().getId());
            orderItemEntity.setQuantity(orderItem.getQuantity());
            orderItemEntity.setUnitaryPrice(orderItem.getUnitaryPrice());
            orderItemEntity.setDiscountAmount(orderItem.getDiscountAmount());
            orderItemEntity.setTotalPrice(orderItem.getTotalPrice());
            orderItemEntityList.add(orderItemEntity);
        }
        return orderItemEntityList;
    }

    private BigDecimal getTotalOrder(List<OrderItem> items) {
        //for (OrderItem orderItem : items) {
        //}
        //return total;
    }
}
