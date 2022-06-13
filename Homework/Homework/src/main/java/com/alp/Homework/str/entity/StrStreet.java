package com.alp.Homework.str.entity;

import com.alp.Homework.dis.entity.DisDistrict;
import com.alp.Homework.nei.entity.NeiNeighborhood;
import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "STR_STREET")
@Data
public class StrStreet {
    @Id
    @SequenceGenerator(name = "StrStreet", sequenceName = "STR_STREET_ID_SEQ")
    @GeneratedValue(generator = "StrStreet")
    private Long id;

    @Column(name = "STREET_NAME")
    private String streetName;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_NEI_NEIGHBORHOOD")
    private NeiNeighborhood neiNeighborhood;
}
