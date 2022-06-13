package com.alp.Homework.cou.entity;

import com.alp.Homework.cty.entity.CtyCity;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;
import java.util.Locale;
import java.util.Set;

@Entity
@Table(name = "COU_COUNTRY")
@Data
public class CouCountry {
    @Id
    @SequenceGenerator(name = "CouCountry", sequenceName = "COU_COUNTRY_ID_SEQ")
    @GeneratedValue(generator = "CouCountry")
    private Long id;

    @Column(name = "COUNTRY_NAME", length = 30)
    private String countryName;

    @Column(name = "COUNTRY_CODE")
    private Long countryCode;

    // @OneToMany(mappedBy = "couCountry" ,fetch = FetchType.LAZY)
    // private List<CtyCity> ctyCities;
}
