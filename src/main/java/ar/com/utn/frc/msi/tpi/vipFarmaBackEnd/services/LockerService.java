package ar.com.utn.frc.msi.tpi.vipFarmaBackEnd.services;

import ar.com.utn.frc.msi.tpi.vipFarmaBackEnd.entity.LockerEntity;
import ar.com.utn.frc.msi.tpi.vipFarmaBackEnd.model.catalog.Product;
import ar.com.utn.frc.msi.tpi.vipFarmaBackEnd.model.stock.Locker;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface LockerService extends BaseModelService<Locker, LockerEntity> {

    List<Locker> getAllByProduct(Long productId);

    List<Locker> getAllByProductAndAvailability(Long productId, Integer availability);
}
