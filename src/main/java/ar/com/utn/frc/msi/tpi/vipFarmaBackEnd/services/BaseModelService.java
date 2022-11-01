package ar.com.utn.frc.msi.tpi.vipFarmaBackEnd.services;

import ar.com.utn.frc.msi.tpi.vipFarmaBackEnd.entity.Deleteable;

import javax.persistence.Entity;
import java.util.List;

public interface BaseModelService<M, E extends Deleteable> {

    M getById(Long id);

    List<M> getAll();

    List<M> getAllByIds(List<Long> ids);

    M create(M model);

    List<M> createAll(List<M> modelList);

    M update(M model);

    void delete(M model);

}
