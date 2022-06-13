package com.alp.Homework.adr.entity;

import com.alp.Homework.cou.entity.CouCountry;
import com.alp.Homework.cty.entity.CtyCity;
import com.alp.Homework.dis.entity.DisDistrict;
import com.alp.Homework.nei.entity.NeiNeighborhood;
import com.alp.Homework.str.entity.StrStreet;
import lombok.Data;

import javax.persistence.*;


@Entity
@Table(name = "ADR_ADDRESS")
@Data
public class AdrAddress {
    @Id
    @SequenceGenerator(name = "AdrAddress", sequenceName = "ADR_ADDRESS_ID_SEQ")
    @GeneratedValue(generator = "AdrAddress")
    private Long id;


    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_COU_COUNTRY")
    private CouCountry couCountry;


    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_CTY_CITY")
    private CtyCity ctyCity;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_DIS_DISTRICT")
    private DisDistrict disDistrict;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_NEI_NEIGHBORHOOD")
    private NeiNeighborhood neiNeighborhood;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_STR_STREET")
    private StrStreet strStreet;

    @Column(name = "DOOR_NUM")
    private Long doorNum;

    @Column(name = "APARTMENT_NUM")
    private Long apartmentNum;
}
