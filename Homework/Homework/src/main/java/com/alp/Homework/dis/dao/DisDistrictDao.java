package com.alp.Homework.dis.dao;

import com.alp.Homework.dis.entity.DisDistrict;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DisDistrictDao extends JpaRepository<DisDistrict, Long> {
    List<DisDistrict> findAllByCtyCity(Long ctyCityId);
}
