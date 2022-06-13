package com.alp.Homework.dis.service;

import com.alp.Homework.cty.entity.CtyCity;
import com.alp.Homework.cty.service.CtyCityService;
import com.alp.Homework.dis.dao.DisDistrictDao;
import com.alp.Homework.dis.dto.DisDistrictSaveRequestDto;
import com.alp.Homework.dis.entity.DisDistrict;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class DisDistrictService {
    private final DisDistrictDao disDistrictDao;
    private final CtyCityService ctyCityService;

    public DisDistrict save(DisDistrictSaveRequestDto saveRequestDto){
        DisDistrict disDistrict = new DisDistrict();
        CtyCity city = ctyCityService.findById(saveRequestDto.getCityId());
        disDistrict.setCtyCity(city);
        disDistrict.setDistrictName(saveRequestDto.getDistrictName());
        disDistrictDao.save(disDistrict);
        return disDistrict;
    }

    public DisDistrict findById(Long id){
        Optional<DisDistrict> districtOptional = disDistrictDao.findById(id);
        if (districtOptional.isPresent())
            return districtOptional.get();
        else
            throw new RuntimeException("District not found");
    }

    public List<DisDistrict> findDistrictsByCityId(Long cityId){
        return disDistrictDao.findAllByCtyCity(cityId);
    }
}
