package ar.com.utn.frc.msi.tpi.vipFarmaBackEnd.services.impl;

import ar.com.utn.frc.msi.tpi.vipFarmaBackEnd.entity.OrderItemEntity;
import ar.com.utn.frc.msi.tpi.vipFarmaBackEnd.entity.SaleOrderEntity;
import ar.com.utn.frc.msi.tpi.vipFarmaBackEnd.model.sale.OrderItem;
import ar.com.utn.frc.msi.tpi.vipFarmaBackEnd.model.sale.SaleOrder;
import ar.com.utn.frc.msi.tpi.vipFarmaBackEnd.model.sale.SaleOrderStatus;
import ar.com.utn.frc.msi.tpi.vipFarmaBackEnd.services.SaleOrderService;
import ar.com.utn.frc.msi.tpi.vipFarmaBackEnd.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.LinkedList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class SaleOrderServiceImpl implements SaleOrderService {

    private UserService userService;

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
    public List<SaleOrder> getOrders(String saleOrderStatus, String branchOffice) {
        return null;
    }

    @Override
    public SaleOrder changeStatus(Long id, String status) {
        return null;
    }

    @Override
    public SaleOrder changeOrder(Long id, SaleOrder saleOrder) {
        return null;
    }

    @Override
    public SaleOrder getOrder(Long id) {
        return null;
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

        for(OrderItem orderItem : orderItems) {
            OrderItemEntity orderItemEntity = new OrderItemEntity();
            orderItemEntity.setOrderId(id);
            // TODO - Completar el seteo
            orderItemEntityList.add(orderItemEntity);
        }
        return orderItemEntityList;
    }

    private BigDecimal getTotalOrder(List<OrderItem> items) {
        return null;
    }
}
