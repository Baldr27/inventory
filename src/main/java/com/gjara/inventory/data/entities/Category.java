package com.gjara.inventory.data.entities;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import org.hibernate.annotations.Formula;

@Entity
@Table(name = "categories")
public class Category implements Serializable {
    @Id
    @NotBlank
    private String name;

    @OneToMany(mappedBy = "categories", fetch = FetchType.LAZY)
    private Set<Product> products = new HashSet<>();

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
    public Set<Product> getProducts(){
        return products;
    }
    public void setProducts(Set<Product> products){
        this.products = products;
    }
    public int getProductCount(){
        return productCount;
    }
}
