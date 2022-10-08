package com.gjara.inventory.data.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gjara.inventory.data.entities.User;

public interface IUserRepository extends JpaRepository<User, Long> {

    
}
