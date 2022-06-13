package com.alp.Homework.cty.service;

import com.alp.Homework.cou.entity.CouCountry;
import com.alp.Homework.cou.service.CouCountryService;
import com.alp.Homework.cty.dao.CtyCityDao;
import com.alp.Homework.cty.dto.CtyCitySaveRequestDto;
import com.alp.Homework.cty.entity.CtyCity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CtyCityService {
    private final CtyCityDao cityDao;
    private final CouCountryService couCountryService;

    public CtyCity save(CtyCitySaveRequestDto saveRequestDto){
        CtyCity ctyCity = new CtyCity();
        CouCountry couCountry = couCountryService.findById(saveRequestDto.getCouCountryId());
        ctyCity.setCouCountry(couCountry);
        ctyCity.setCityName(saveRequestDto.getCityName());
        ctyCity.setLicensePlate(saveRequestDto.getLicensePlate());
        ctyCity = cityDao.save(ctyCity);
        return ctyCity;
    }

    public CtyCity findById(Long id){
        Optional<CtyCity> cityOptional = cityDao.findById(id);
        if (cityOptional.isPresent())
            return cityOptional.get();
        else
            throw new RuntimeException("City not found");
    }

    public CtyCity findByLicensePlate(String licensePlate){
        return cityDao.findByLicensePlate(licensePlate);
    }
}
