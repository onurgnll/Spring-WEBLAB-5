package com.onur.weblabprojesi.service;

import com.onur.weblabprojesi.model.Product;

import java.util.List;

public interface ProductService {
    Product getProductById(Long id); // Tek bir ürünü ID ile al
    void deleteProductById(Long id); // Ürünü ID ile sil

    List<Product> getAllProducts();
    List<Product> searchProductsByName(String name);
    List<Product> getProductsByCategory(Long categoryId); // Kategoriye göre ürünleri getir
    void saveProduct(Product product);
}
