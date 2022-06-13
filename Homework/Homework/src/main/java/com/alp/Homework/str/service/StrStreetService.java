package com.alp.Homework.str.service;

import com.alp.Homework.dis.entity.DisDistrict;
import com.alp.Homework.nei.dto.NeiNeighborhoodSaveRequestDto;
import com.alp.Homework.nei.entity.NeiNeighborhood;
import com.alp.Homework.nei.service.NeiNeighborhoodService;
import com.alp.Homework.str.dao.StrStreetDao;
import com.alp.Homework.str.dto.StrStreetSaveRequestDto;
import com.alp.Homework.str.entity.StrStreet;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class StrStreetService {
    private final NeiNeighborhoodService neiNeighborhoodService;
    private final StrStreetDao strStreetDao;

    public StrStreet save(StrStreetSaveRequestDto saveRequestDto){
        StrStreet strStreet = new StrStreet();
        NeiNeighborhood neiNeighborhood = neiNeighborhoodService.findById(saveRequestDto.getNeighborhoodId());
        strStreet.setNeiNeighborhood(neiNeighborhood);
        strStreet.setStreetName(saveRequestDto.getStreetName());
        strStreet = strStreetDao.save(strStreet);
        return strStreet;
    }

    public StrStreet findById(Long id){
        Optional<StrStreet> optionalStrStreet = strStreetDao.findById(id);
        if (optionalStrStreet.isPresent())
            return optionalStrStreet.get();
        else throw new RuntimeException("Street not found");
    }
}
