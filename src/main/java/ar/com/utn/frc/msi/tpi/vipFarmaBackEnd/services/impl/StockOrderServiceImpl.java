package ar.com.utn.frc.msi.tpi.vipFarmaBackEnd.services.impl;

import ar.com.utn.frc.msi.tpi.vipFarmaBackEnd.entity.BranchOfficeEntity;
import ar.com.utn.frc.msi.tpi.vipFarmaBackEnd.entity.SaleOrderEntity;
import ar.com.utn.frc.msi.tpi.vipFarmaBackEnd.entity.StockOrderEntity;
import ar.com.utn.frc.msi.tpi.vipFarmaBackEnd.entity.WarehouseEntity;
import ar.com.utn.frc.msi.tpi.vipFarmaBackEnd.model.catalog.Product;
import ar.com.utn.frc.msi.tpi.vipFarmaBackEnd.model.sale.SaleOrder;
import ar.com.utn.frc.msi.tpi.vipFarmaBackEnd.model.sale.SaleOrderItem;
import ar.com.utn.frc.msi.tpi.vipFarmaBackEnd.model.sale.SaleOrderStatus;
import ar.com.utn.frc.msi.tpi.vipFarmaBackEnd.model.stock.*;
import ar.com.utn.frc.msi.tpi.vipFarmaBackEnd.repositories.SaleOrderRepository;
import ar.com.utn.frc.msi.tpi.vipFarmaBackEnd.repositories.StockOrderRepository;
import ar.com.utn.frc.msi.tpi.vipFarmaBackEnd.services.*;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;


@Service
@RequiredArgsConstructor
public class StockOrderServiceImpl extends BaseModelServiceImpl<StockOrder, StockOrderEntity> implements StockOrderService {

    private final UserService userService;

    private final StockOrderItemService stockOrderItemService;

    private final StockOrderRepository stockOrderRepository;

    private final StockService stockService;

    private final ModelMapper modelMapper;

    Random random = new Random();

    @Override
    protected JpaRepository getJpaRepository() {
        return this.stockOrderRepository;
    }

    @Override
    protected ModelMapper getModelMapper() {
        return this.modelMapper;
    }

    @Override
    @Transactional
    public StockOrder create(StockOrder stockOrder) {

        // Set status to CREATED, creation date and save Order
        stockOrder.setStockOrderStatus(StockOrderStatus.CREATED);
        stockOrder.setCreatedDate(LocalDate.now());
        stockOrder.setPurchaseOrderId(random.nextLong());
        StockOrder savedOrder = super.create(stockOrder);

        // Set orderId in each items and save items
        if(stockOrder.getStockOrderItems() != null && !stockOrder.getStockOrderItems().isEmpty()) {
            List<StockOrderItem> savedItems = saveStockOrderItems(
                    stockOrder.getStockOrderItems(),
                    savedOrder.getId());
            // Set itemsSaved into order saved
            savedOrder.setStockOrderItems(savedItems);
        }
        return savedOrder;
    }


    private List<StockOrderItem> saveStockOrderItems(List<StockOrderItem> stockOrderItems, Long savedOrderId) {
        for(StockOrderItem item : stockOrderItems) {
            item.setStockOrderId(savedOrderId);
            item.setStockOrderItemStatus(StockOrderItemStatus.CREATED);
            if(item.getLockersToSave() != null && !item.getLockersToSave().isEmpty()) {
                for(Locker locker : item.getLockersToSave()) {
                    createStock(item, locker);
                }
            }
        }
        return stockOrderItemService.createAll(stockOrderItems);
    }

    private void createStock(StockOrderItem item, Locker locker) {
        Stock stock = new Stock();
        stock.setProduct(item.getProduct());
        stock.setInitialStock(item.getActualQuantity());
        stock.setAvailableStock(item.getActualQuantity());
        stock.setCreatedDate(LocalDate.now());
        stock.setLocker(locker);
        stock.setDueDate(LocalDate.now().plusDays(300));
        stock.setStockStatus(StockStatus.ACTIVE);
        stockService.create(stock);
    }

    @Override
    public List<StockOrder> getOrdersByStatusAndWarehouse(StockOrderStatus stockOrderStatus, Long warehouseId) {
        WarehouseEntity warehouse = new WarehouseEntity();
        warehouse.setId(warehouseId);
        List<StockOrderEntity> ordersList = stockOrderRepository.getByStockOrderStatusAndWarehouseId(stockOrderStatus, warehouse);
        return ordersList.stream()
                .map(entity -> getModelMapper().map(entity, StockOrder.class))
                .collect(Collectors.toList());
    }

    @Override
    public List<StockOrder> getOrdersByStatusAndBranchOffice(StockOrderStatus stockOrderStatus, Long branchOfficeId) {
        List<StockOrderEntity> ordersList = stockOrderRepository.getByStockOrderStatusAndBranchOffice(stockOrderStatus, branchOfficeId);
        return ordersList.stream()
                .map(entity -> getModelMapper().map(entity, StockOrder.class))
                .collect(Collectors.toList());
    }

    @Override
    public StockOrder changeStatus(Long id, StockOrderStatus stockOrderStatus, StockOrder stockOrder) {
        StockOrder actualOrder = this.getById(id);
        if(stockOrderStatus == StockOrderStatus.PENDING_DELIVERY && actualOrder.getStockOrderStatus() == StockOrderStatus.CREATED) {
            stockOrder.getStockOrderItems().forEach(
                    item -> {
                        item.setStockOrderItemStatus(StockOrderItemStatus.PENDING);
                        stockOrderItemService.update(item);
                    });
            stockOrderItemService.updateAll(stockOrder.getStockOrderItems());
            stockOrder.setStockOrderStatus(stockOrderStatus);
            actualOrder = this.update(stockOrder);
        } else if (stockOrderStatus == StockOrderStatus.CANCELED && actualOrder.getStockOrderStatus() == StockOrderStatus.PENDING_DELIVERY) {
            actualOrder.getStockOrderItems().forEach(
                    item -> {
                        item.setStockOrderItemStatus(StockOrderItemStatus.CANCELED);
                        stockOrderItemService.update(item);
                    });
            stockOrderItemService.updateAll(actualOrder.getStockOrderItems());
            actualOrder.setStockOrderStatus(stockOrderStatus);
            actualOrder = this.update(actualOrder);
        } else if (stockOrderStatus == StockOrderStatus.REJECTED && actualOrder.getStockOrderStatus() == StockOrderStatus.PENDING_DELIVERY) {
            actualOrder.getStockOrderItems().forEach(
                    item -> {
                        item.setStockOrderItemStatus(StockOrderItemStatus.RETURNED);
                        stockOrderItemService.update(item);
                    });
            stockOrderItemService.updateAll(actualOrder.getStockOrderItems());
            stockOrder.setStockOrderStatus(stockOrderStatus);
            actualOrder = this.update(stockOrder);
        } else if (stockOrderStatus == StockOrderStatus.RECEIVED && actualOrder.getStockOrderStatus() == StockOrderStatus.PENDING_DELIVERY) {
            stockOrder.getStockOrderItems().forEach(
                    item -> {
                        if(item.getStockOrderItemStatus() == StockOrderItemStatus.CREATED ||
                                item.getStockOrderItemStatus() == StockOrderItemStatus.PENDING) {
                            throw new IllegalArgumentException("Order items can´t by in CREATED or PENDING status to " +
                                    "set the order in RECEIVED status");
                        }
                    });
            stockOrderItemService.updateAll(actualOrder.getStockOrderItems());
            stockOrder.setStockOrderStatus(stockOrderStatus);
            actualOrder = this.update(stockOrder);
        } else {
            throw new IllegalArgumentException(String.format("This operation is not allowed, can´t go from %s " +
                    " status to %s status.", actualOrder.getStockOrderStatus(), stockOrderStatus));
        }
        return actualOrder;
    }
}
