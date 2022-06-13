package com.alp.Homework.cou.service;

import com.alp.Homework.cou.dao.CouCountryDao;
import com.alp.Homework.cou.dto.CouCountrySaveRequestDto;
import com.alp.Homework.cou.entity.CouCountry;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CouCountryService {

    private final CouCountryDao couCountryDao;


    public CouCountry save(CouCountrySaveRequestDto saveRequestDto){
        CouCountry country = new CouCountry();
        country.setCountryCode(saveRequestDto.getCountryCode());
        country.setCountryName(saveRequestDto.getCountryName());
        //country.setCtyCities(null);
        CouCountry savedCountry = couCountryDao.save(country);
        return savedCountry;
    }

    public CouCountry findById(Long id){
        Optional<CouCountry> countryOptional = couCountryDao.findById(id);
        if (countryOptional.isPresent())
            return countryOptional.get();
        else
            throw new RuntimeException("Country not found");
    }

    public CouCountry findByCountryCode(Long countryCode){
        return couCountryDao.findByCountryCode(countryCode);
    }
}
