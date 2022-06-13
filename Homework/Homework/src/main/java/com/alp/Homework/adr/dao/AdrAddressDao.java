package com.alp.Homework.adr.dao;

import com.alp.Homework.adr.entity.AdrAddress;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdrAddressDao extends JpaRepository<AdrAddress, Long> {
}
