package ar.com.utn.frc.msi.tpi.vipFarmaBackEnd.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.MappedSuperclass;

@Data
@AllArgsConstructor
@NoArgsConstructor
@MappedSuperclass
public abstract class Deleteable {

    private Boolean isDeleted;

    public void delete() {
        this.isDeleted = true;
    }
}
