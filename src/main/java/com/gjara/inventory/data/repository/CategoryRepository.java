package com.gjara.inventory.data.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gjara.inventory.data.entities.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Integer> {
    
}
