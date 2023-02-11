package com.example.warehouse.controller;

import com.example.warehouse.Entity.Category;
import com.example.warehouse.Model.CategoryDto;
import com.example.warehouse.Model.Result;
import com.example.warehouse.Servis.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/category")
public class CategoryController {
    @Autowired
    CategoryService categoryService;

    @PostMapping
    public Result addCategoryC(@RequestBody CategoryDto category) {
        Result result = categoryService.addCategoryService(category);
        return result;
    }

    @GetMapping
    public List<Category> getCategory() {
        List<Category> categoryService1 = categoryService.getCategoryService();
        return categoryService1;
    }

    @GetMapping("/{id}")
    public Category getCategoryId(@PathVariable Integer id) {
        Category categoryById = categoryService.getCategoryById(id);
        return categoryById;
    }
    @PutMapping("/{id}")
    public Result putCategory(@PathVariable Integer id, @RequestBody CategoryDto categoryDto) {
        Result result = categoryService.putCategory(id, categoryDto);
        return result;
    }
    @DeleteMapping("/{id}")
    public Result deleteCategory(@PathVariable Integer id) {
        Result result = categoryService.deleteCategory(id);
        return result;
    }
}
