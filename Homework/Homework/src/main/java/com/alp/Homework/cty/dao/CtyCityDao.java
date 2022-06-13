package com.alp.Homework.cty.dao;

import com.alp.Homework.cty.entity.CtyCity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CtyCityDao extends JpaRepository<CtyCity, Long> {
    CtyCity findByLicensePlate(String licensePlate);
}
