package com.onur.weblabprojesi.controller;

import com.onur.weblabprojesi.model.Product;
import com.onur.weblabprojesi.service.CategoryService;
import com.onur.weblabprojesi.service.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class HomeController {

    private final CategoryService categoryService;
    private final ProductService productService;

    public HomeController(CategoryService categoryService, ProductService productService) {
        this.categoryService = categoryService;
        this.productService = productService;
    }

    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("categories", categoryService.getAllCategories());
        model.addAttribute("products", productService.getAllProducts());
        return "home";
    }
    @GetMapping("/search")
    public String searchProducts(@RequestParam String name, Model model) {
        List<Product> products = productService.searchProductsByName(name);
        model.addAttribute("categories", categoryService.getAllCategories());
        model.addAttribute("products", products);
        model.addAttribute("searchTerm", name); // Arama terimini şablonda göstermek için ekliyoruz
        return "home"; // Aynı şablon üzerinde arama sonuçlarını göster
    }
    @GetMapping("/category")
    public String getProductsByCategory(@RequestParam Long id, Model model) {
        model.addAttribute("categories", categoryService.getAllCategories());
        model.addAttribute("products", productService.getProductsByCategory(id));
        return "home"; // Aynı şablonu kullanabiliriz
    }
}
