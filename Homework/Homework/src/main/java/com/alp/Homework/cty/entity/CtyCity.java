package com.alp.Homework.cty.entity;

import com.alp.Homework.cou.entity.CouCountry;
import com.alp.Homework.dis.entity.DisDistrict;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;


@Entity
@Table(name = "CTY_CITY")
@Data
public class CtyCity {
    @Id
    @SequenceGenerator(name = "CtyCity", sequenceName = "CTY_CITY_ID_SEQ")
    @GeneratedValue(generator = "CtyCity")
    private Long id;

    @Column(name = "CITY_NAME")
    private String cityName;

    @Column(name = "LICENSE_PLATE")
    private String licensePlate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_COU_COUNTRY")
    private CouCountry couCountry;

    //@OneToMany(mappedBy = "ctyCity",fetch = FetchType.LAZY)
    //private List<DisDistrict> disDistricts;
}
