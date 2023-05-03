package com.cytech.trashtreasure.repository;

import org.springframework.data.repository.CrudRepository;

import com.cytech.trashtreasure.entity.User;

public interface UserRepository extends CrudRepository<User, Integer> {
    User findByUsername(String username);
    
}
