package com.cytech.trashtreasure.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.cytech.trashtreasure.entity.Trash;
import com.cytech.trashtreasure.entity.User;

import java.util.ArrayList;

public interface TrashRepository extends JpaRepository<Trash, Integer> {
    public ArrayList<Trash> findByDepositor(User depositor);

    @Query("SELECT t FROM Trash t INNER JOIN t.trashConfig tc WHERE tc.type = ?1")
    public ArrayList<Trash> findByType(String type);
}
