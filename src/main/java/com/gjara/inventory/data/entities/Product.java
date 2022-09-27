package com.gjara.inventory.data.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.springframework.lang.Nullable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


@Entity
public class Product {

    @Id
    @GeneratedValue
    private Long id;
    @NotEmpty
    @NotBlank
    private String name;
    @Nullable
    private String description;
    @Nullable
    private Double quantity;
    @ManyToOne
    @JoinColumn(name = "category_id")
    @NotNull
    @JsonIgnoreProperties({"products"})
    private Category category;

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
