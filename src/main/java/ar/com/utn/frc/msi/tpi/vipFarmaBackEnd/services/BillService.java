package ar.com.utn.frc.msi.tpi.vipFarmaBackEnd.services;

import ar.com.utn.frc.msi.tpi.vipFarmaBackEnd.entity.BillEntity;
import ar.com.utn.frc.msi.tpi.vipFarmaBackEnd.model.billing.Bill;
import ar.com.utn.frc.msi.tpi.vipFarmaBackEnd.services.BaseModelService;

import java.util.List;

public interface BillService extends BaseModelService<Bill, BillEntity> {

    Bill billOrder(Long id, Long userId, Boolean preview);

    List<Bill> getAllBills();
}
