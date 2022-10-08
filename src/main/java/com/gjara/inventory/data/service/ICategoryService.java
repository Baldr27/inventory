package com.gjara.inventory.data.service;

import java.util.List;

import com.gjara.inventory.data.entities.Category;

public interface ICategoryService {
    
    List<Category> getAllCategories();
    List<Category> getCategoriesByName(String name);
    Category saveCategory(Category category);
    Category updateCategory(Category category);
    Category getCategoryById(Long id);
    void deleteCategory(Long id);

}
