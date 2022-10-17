package ar.com.utn.frc.msi.tpi.vipFarmaBackEnd.services;

import javax.persistence.Entity;
import java.util.List;

public interface BaseModelService<M, E> {

    M getById(Long id);

    List<M> getAll();

    M create(M model);

    List<M> createAll(List<M> modelList);

    M update(M model);

}
