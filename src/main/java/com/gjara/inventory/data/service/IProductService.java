package com.gjara.inventory.data.service;

import java.util.List;

import com.gjara.inventory.data.entities.Product;

public interface IProductService {
    
    List<Product> getAllProducts();
    List<Product> getProductsByName(String name);
    Product saveProduct(Product product);
    Product updateProduct(Product product);
    Product getProductById(Long id);
    void deleteProduct(Long id);
}
