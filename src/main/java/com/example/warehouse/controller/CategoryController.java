package com.example.warehouse.controller;

import com.example.warehouse.Entity.Category;
import com.example.warehouse.Model.Result;
import com.example.warehouse.Repository.CategoryRepository;
import com.example.warehouse.Servis.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/category")
public class CategoryController {
    @Autowired
    CategoryService categoryService;

    @PostMapping
    public Result addCategoryC(@RequestBody Category category) {
        Result result = categoryService.addCategory(category);
        return result;
    }
}
