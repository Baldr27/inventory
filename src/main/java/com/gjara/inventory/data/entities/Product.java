package com.gjara.inventory.data.entities;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

import org.springframework.lang.Nullable;

@Entity
@Table(name = "products")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotEmpty
    @NotBlank
    @Column(name = "name")
    private String name;
    @Nullable
    @Column(name = "description")
    private String description;
    @Nullable
    @Column(name = "quantity")
    private Double quantity;
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    @JoinTable(name="product_categories", joinColumns = {@JoinColumn(name="product_id", referencedColumnName="id", nullable=false, updatable=false)},
    inverseJoinColumns = {@JoinColumn(name="category_id", referencedColumnName="id", nullable=false, updatable=false)})
    private Category category;

    public Product(String name, String description, Double quantity) {
        this.name = name;
        this.description = description;
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "Name : "+ name + " Quantity: " + quantity;
    }

    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name = name;
    }
    public String getDescription(){
        return description;
    }
    public void setDescription(String description){
        this.description = description;
    }
    public Double getQuantity(){
        return quantity;
    }
    public void setQuantity(Double quantity){
        this.quantity = quantity;
    }
    public Category getCategory(){
        return category;
    }
    public void setCategory(Category category){
        this.category = category;
    }
    public Long getId(){
        return id;
    }
}
