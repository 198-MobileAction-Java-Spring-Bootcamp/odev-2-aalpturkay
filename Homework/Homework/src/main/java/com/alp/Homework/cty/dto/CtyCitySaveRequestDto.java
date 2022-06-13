package com.alp.Homework.cty.dto;

import com.alp.Homework.cou.entity.CouCountry;
import com.alp.Homework.dis.entity.DisDistrict;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
public class CtyCitySaveRequestDto {
    private Long couCountryId;

    private String cityName;

    private String licensePlate;
}
