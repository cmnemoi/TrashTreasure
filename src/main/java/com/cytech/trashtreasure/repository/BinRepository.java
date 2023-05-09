package com.cytech.trashtreasure.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cytech.trashtreasure.entity.Bin;

public interface BinRepository extends JpaRepository<Bin, Integer> {
    public Bin findByColor(String color);
}
