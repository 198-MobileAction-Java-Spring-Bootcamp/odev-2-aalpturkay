package com.alp.Homework.adr.service;

import com.alp.Homework.adr.dao.AdrAddressDao;
import com.alp.Homework.adr.dto.AdrAddressSaveRequestDto;
import com.alp.Homework.adr.entity.AdrAddress;
import com.alp.Homework.cou.service.CouCountryService;
import com.alp.Homework.cty.service.CtyCityService;
import com.alp.Homework.dis.service.DisDistrictService;
import com.alp.Homework.nei.service.NeiNeighborhoodService;
import com.alp.Homework.str.service.StrStreetService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AdrAddressService {
    private final AdrAddressDao adrAddressDao;
    private final CouCountryService couCountryService;
    private final CtyCityService ctyCityService;
    private final DisDistrictService disDistrictService;
    private final NeiNeighborhoodService neiNeighborhoodService;
    private final StrStreetService strStreetService;

    public AdrAddress save(AdrAddressSaveRequestDto saveRequestDto){
        AdrAddress adrAddress = new AdrAddress();
        adrAddress.setApartmentNum(saveRequestDto.getApartmentNum());
        adrAddress.setDoorNum(saveRequestDto.getDoorNum());

        adrAddress.setCouCountry(couCountryService.findById(saveRequestDto.getCouCountryId()));
        adrAddress.setCtyCity(ctyCityService.findById(saveRequestDto.getCtyCityId()));
        adrAddress.setDisDistrict(disDistrictService.findById(saveRequestDto.getDisDistrictId()));
        adrAddress.setNeiNeighborhood(neiNeighborhoodService.findById(saveRequestDto.getNeiNeighborhoodId()));
        adrAddress.setStrStreet(strStreetService.findById(saveRequestDto.getStrStreetId()));

        adrAddress = adrAddressDao.save(adrAddress);
        return adrAddress;
    }
}
