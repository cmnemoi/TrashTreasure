package com.cytech.trashtreasure.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cytech.trashtreasure.entity.Voucher;

public interface VoucherRepository extends JpaRepository<Voucher, Integer> {
    
}
