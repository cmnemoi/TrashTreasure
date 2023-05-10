package com.cytech.trashtreasure.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cytech.trashtreasure.entity.VoucherConfig;

public interface VoucherConfigRepository extends JpaRepository<VoucherConfig, Integer> {
    
}
