package com.cytech.trashtreasure.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cytech.trashtreasure.entity.Trash;
import com.cytech.trashtreasure.entity.User;

import java.util.ArrayList;

public interface TrashRepository extends JpaRepository<Trash, Integer> {
    public ArrayList<Trash> findByDepositor(User depositor);
}
