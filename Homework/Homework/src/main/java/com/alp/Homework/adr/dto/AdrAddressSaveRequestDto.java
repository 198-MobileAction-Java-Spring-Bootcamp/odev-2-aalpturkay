package com.alp.Homework.adr.dto;

import com.alp.Homework.cou.entity.CouCountry;
import com.alp.Homework.cty.entity.CtyCity;
import com.alp.Homework.dis.entity.DisDistrict;
import com.alp.Homework.nei.entity.NeiNeighborhood;
import com.alp.Homework.str.entity.StrStreet;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Data
public class AdrAddressSaveRequestDto {
    private Long couCountryId;

    private Long ctyCityId;

    private Long disDistrictId;

    private Long neiNeighborhoodId;

    private Long strStreetId;

    private Long doorNum;

    private Long apartmentNum;
}
