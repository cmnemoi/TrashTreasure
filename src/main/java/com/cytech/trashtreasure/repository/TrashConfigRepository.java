package com.cytech.trashtreasure.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cytech.trashtreasure.entity.TrashConfig;

public interface TrashConfigRepository extends JpaRepository<TrashConfig, Integer> {
    public TrashConfig findByName(String name);
}
