package com.gjara.inventory.data.repository;


import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gjara.inventory.data.entities.Category;

public interface ICategoryRepository extends JpaRepository<Category, Integer> {

    List<Category> findByName(String name);

    Optional<Category> findById(Long id);

    void deleteById(Long id);
    
}
