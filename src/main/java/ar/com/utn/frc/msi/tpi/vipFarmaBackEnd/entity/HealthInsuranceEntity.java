package ar.com.utn.frc.msi.tpi.vipFarmaBackEnd.entity;

import lombok.Data;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;
import java.util.List;

@Data
@Entity(name = "healthInsurance")
public class HealthInsuranceEntity {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;
    private String name;
    private String number;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "healthInsuranceId")
    @Fetch(FetchMode.SELECT)
    private List<HealthInsurancePlanEntity> availablePlans;
}
