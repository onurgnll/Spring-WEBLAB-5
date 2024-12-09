package com.onur.weblabprojesi.service;

import com.onur.weblabprojesi.model.Category;
import java.util.List;

public interface CategoryService {
    List<Category> getAllCategories();
    Category getCategoryById(Long id);
    void saveCategory(Category category);
    void deleteCategory(Long id);
}
