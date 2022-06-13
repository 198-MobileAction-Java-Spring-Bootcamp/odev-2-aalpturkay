package com.alp.Homework.dis.entity;

import com.alp.Homework.adr.entity.AdrAddress;
import com.alp.Homework.cty.entity.CtyCity;
import com.alp.Homework.nei.entity.NeiNeighborhood;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "DIS_DISTRICT")
@Data
public class DisDistrict {
    @Id
    @SequenceGenerator(name = "DisDistrict", sequenceName = "DIS_DISTRICT_ID_SEQ")
    @GeneratedValue(generator = "DisDistrict")
    private Long id;

    //@OneToMany(fetch = FetchType.LAZY)
    //@JoinColumn(name = "disDistrict")
    //private List<NeiNeighborhood> neiNeighborhoods;

    @Column(name = "DISTRICT_NAME")
    private String districtName;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_CTY_CITY")
    private CtyCity ctyCity;
}
