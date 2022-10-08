package com.gjara.inventory.data.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.gjara.inventory.data.entities.Product;

public interface IProductRepository extends JpaRepository<Product, Long> {
    
    @Query("select p from Product p " +
        "where lower(p.name) like lower(concat('%', :searchTerm, '%')) ")
        List<Product> search(@Param("searchTerm") String searchTerm);

    @Query("FROM Product p WHERE p.category.id = :id")
        List<Product> findByCategoryId(@Param("id") Long id);

    List<Product> findByName(String name);

}
