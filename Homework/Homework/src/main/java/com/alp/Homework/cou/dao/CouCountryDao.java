package com.alp.Homework.cou.dao;

import com.alp.Homework.cou.entity.CouCountry;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CouCountryDao extends JpaRepository<CouCountry, Long> {
    CouCountry findByCountryCode(Long countryCode);
}
