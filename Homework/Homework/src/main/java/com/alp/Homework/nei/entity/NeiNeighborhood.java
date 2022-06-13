package com.alp.Homework.nei.entity;

import com.alp.Homework.dis.entity.DisDistrict;
import com.alp.Homework.str.entity.StrStreet;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "NEI_NEIGHBORHOOD")
@Data
public class NeiNeighborhood {
    @Id
    @SequenceGenerator(name = "NeiNeighborhood", sequenceName = "NEI_NEIGHBORHOOD_ID_SEQ")
    @GeneratedValue(generator = "NeiNeighborhood")
    private Long id;


    //@OneToMany(mappedBy = "neiNeighborhood", fetch = FetchType.LAZY)
    //private List<StrStreet> strStreets;

    @Column(name = "NEIGHBORHOOD_NAME")
    private String neighborhoodName;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_DIS_DISTRICT")
    private DisDistrict disDistrict;
}
