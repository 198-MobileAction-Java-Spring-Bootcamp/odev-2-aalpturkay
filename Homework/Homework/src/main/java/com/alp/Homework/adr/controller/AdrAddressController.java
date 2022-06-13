package com.alp.Homework.adr.controller;

import com.alp.Homework.adr.dto.AdrAddressSaveRequestDto;
import com.alp.Homework.adr.entity.AdrAddress;
import com.alp.Homework.adr.service.AdrAddressService;
import com.alp.Homework.cou.dto.CouCountryFindRequestDto;
import com.alp.Homework.cou.dto.CouCountrySaveRequestDto;
import com.alp.Homework.cou.entity.CouCountry;
import com.alp.Homework.cou.service.CouCountryService;
import com.alp.Homework.cty.dto.CtyCityFindRequestDto;
import com.alp.Homework.cty.dto.CtyCitySaveRequestDto;
import com.alp.Homework.cty.entity.CtyCity;
import com.alp.Homework.cty.service.CtyCityService;
import com.alp.Homework.dis.dto.DisDistrictFindRequestDto;
import com.alp.Homework.dis.dto.DisDistrictSaveRequestDto;
import com.alp.Homework.dis.entity.DisDistrict;
import com.alp.Homework.dis.service.DisDistrictService;
import com.alp.Homework.nei.dao.NeiNeighborhoodDao;
import com.alp.Homework.nei.dto.NeiNeighborhoodSaveRequestDto;
import com.alp.Homework.nei.entity.NeiNeighborhood;
import com.alp.Homework.nei.service.NeiNeighborhoodService;
import com.alp.Homework.str.dto.StrStreetSaveRequestDto;
import com.alp.Homework.str.entity.StrStreet;
import com.alp.Homework.str.service.StrStreetService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("/addresses")
@RequiredArgsConstructor
public class AdrAddressController {
    private final AdrAddressService adrAddressService;
    private final CouCountryService couCountryService;
    private final CtyCityService ctyCityService;
    private final DisDistrictService disDistrictService;
    private final NeiNeighborhoodService neiNeighborhoodService;
    private final StrStreetService strStreetService;

    @PostMapping
    public ResponseEntity<AdrAddress> saveAddress(@RequestBody AdrAddressSaveRequestDto saveRequestDto){
        AdrAddress adrAddress = adrAddressService.save(saveRequestDto);
        return new ResponseEntity<>(adrAddress, HttpStatus.CREATED);
    }

    @PostMapping("/saveCountry")
    public ResponseEntity<CouCountry> saveCountry(@RequestBody CouCountrySaveRequestDto saveRequestDto){
        CouCountry couCountry = couCountryService.save(saveRequestDto);
        return new ResponseEntity<>(couCountry, HttpStatus.CREATED);
    }

    @PostMapping("/findCountry")
    public ResponseEntity<CouCountry> findCountry(@RequestBody CouCountryFindRequestDto findRequestDto){
        CouCountry couCountry = couCountryService.findByCountryCode(findRequestDto.getCountryCode());
        return new ResponseEntity<>(couCountry,HttpStatus.OK);
    }

    @PostMapping("/saveCity")
    public ResponseEntity<CtyCity> saveCity(@RequestBody CtyCitySaveRequestDto saveRequestDto){
        CtyCity ctyCity = ctyCityService.save(saveRequestDto);
        return new ResponseEntity<>(ctyCity, HttpStatus.CREATED);
    }

    @PostMapping("/findCity")
    public ResponseEntity<CtyCity> findCity(@RequestBody CtyCityFindRequestDto findRequestDto){
        CtyCity city = ctyCityService.findByLicensePlate(findRequestDto.getLicensePlate());
        return new ResponseEntity<>(city, HttpStatus.OK);
    }

    @PostMapping("/saveDistrict")
    public ResponseEntity saveDistrict(@RequestBody DisDistrictSaveRequestDto saveRequestDto){
        DisDistrict disDistrict = disDistrictService.save(saveRequestDto);
        return new ResponseEntity(HttpStatus.CREATED);
    }

    @PostMapping("/findDistrictsByCity")
    public ResponseEntity<List<DisDistrict>> findDistrictsByCity(@RequestBody DisDistrictFindRequestDto findRequestDto){
        List<DisDistrict> districtsByCityId = disDistrictService.findDistrictsByCityId(findRequestDto.getCityId());
        return new ResponseEntity<>(districtsByCityId, HttpStatus.OK);
    }

    @PostMapping("/saveNeighborhood")
    public ResponseEntity saveNeighborhood(@RequestBody NeiNeighborhoodSaveRequestDto saveRequestDto){
        NeiNeighborhood neiNeighborhood = neiNeighborhoodService.save(saveRequestDto);
        return new ResponseEntity(HttpStatus.CREATED);
    }

    @PostMapping("/saveStreet")
    public ResponseEntity saveStreet(@RequestBody StrStreetSaveRequestDto saveRequestDto){
        StrStreet strStreet = strStreetService.save(saveRequestDto);
        return new ResponseEntity(HttpStatus.CREATED);
    }

}
