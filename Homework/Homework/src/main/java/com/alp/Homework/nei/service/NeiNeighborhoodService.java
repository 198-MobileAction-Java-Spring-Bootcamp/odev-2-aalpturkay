package com.alp.Homework.nei.service;

import com.alp.Homework.cty.entity.CtyCity;
import com.alp.Homework.dis.dto.DisDistrictSaveRequestDto;
import com.alp.Homework.dis.entity.DisDistrict;
import com.alp.Homework.dis.service.DisDistrictService;
import com.alp.Homework.nei.dao.NeiNeighborhoodDao;
import com.alp.Homework.nei.dto.NeiNeighborhoodSaveRequestDto;
import com.alp.Homework.nei.entity.NeiNeighborhood;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class NeiNeighborhoodService {
    private final DisDistrictService disDistrictService;
    private final NeiNeighborhoodDao neiNeighborhoodDao;

    public NeiNeighborhood save(NeiNeighborhoodSaveRequestDto saveRequestDto){
        NeiNeighborhood neiNeighborhood = new NeiNeighborhood();
        DisDistrict district = disDistrictService.findById(saveRequestDto.getDistrictId());
        neiNeighborhood.setDisDistrict(district);
        neiNeighborhood.setNeighborhoodName(saveRequestDto.getNeighborhoodName());
        neiNeighborhood = neiNeighborhoodDao.save(neiNeighborhood);
        return neiNeighborhood;
    }

    public NeiNeighborhood findById(Long id){
        Optional<NeiNeighborhood> neighborhoodOptional = neiNeighborhoodDao.findById(id);
        if (neighborhoodOptional.isPresent())
            return neighborhoodOptional.get();
        else
            throw new RuntimeException("Neighborhood not found");
    }
}
