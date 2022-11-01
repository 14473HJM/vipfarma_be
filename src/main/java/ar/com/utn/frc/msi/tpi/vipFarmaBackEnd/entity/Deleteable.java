package ar.com.utn.frc.msi.tpi.vipFarmaBackEnd.entity;

import lombok.Data;

@Data
public class Deleteable {

    private Boolean isDeleted;

    public void delete() {
        this.isDeleted = true;
    }
}
