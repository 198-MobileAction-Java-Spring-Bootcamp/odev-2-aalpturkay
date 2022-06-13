package com.alp.Homework.cou.dto;

import com.alp.Homework.cty.entity.CtyCity;
import lombok.Data;

import java.util.List;

@Data
public class CouCountrySaveRequestDto {
    private String countryName;

    private Long countryCode;
}
