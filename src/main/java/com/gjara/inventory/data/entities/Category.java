package com.gjara.inventory.data.entities;

import java.util.LinkedList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotBlank;

import org.hibernate.annotations.Formula;

@Entity
public class Category extends AbstractEntity {
    @NotBlank
    private String name;

    @OneToMany(mappedBy = "category")
    private List<Product> products = new LinkedList<>();

    @Formula("(select count(c.id) from Product c where c.category_id = id)")
    private int productCount; 

    public Category(String name) {
        this.name = name;
    }
    public Category(){
        this.name = "A";
    }

    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name = name;
    }
    public List<Product> getProducts(){
        return products;
    }
    public void setProducts(List<Product> products){
        this.products = products;
    }
    public int getProductCount(){
        return productCount;
    }
}
