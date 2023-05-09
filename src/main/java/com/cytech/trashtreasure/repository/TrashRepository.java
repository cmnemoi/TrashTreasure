package com.cytech.trashtreasure.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cytech.trashtreasure.entity.Trash;

public interface TrashRepository extends JpaRepository<Trash, Integer> {
}
