package com.gjara.inventory.data.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.gjara.inventory.data.entities.Product;
import com.gjara.inventory.data.repository.IProductRepository;

@Service
public class CrmService {
    
    private final IProductRepository productRepository;

    public CrmService(IProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> findAllProducts(String stringFilter){
        if(stringFilter == null || stringFilter.isEmpty()){
            return productRepository.findAll();
        }else{
            return productRepository.search(stringFilter);
        }
    }

    public long countProducts(){
        return productRepository.count();
    }

    public void deleteProduct(Product product){
        productRepository.delete(product);
    }

    public void saveProduct(Product product){
        if(product == null){
            System.out.println("Product is null");
            return;
        }
        productRepository.save(product);
    }
}
