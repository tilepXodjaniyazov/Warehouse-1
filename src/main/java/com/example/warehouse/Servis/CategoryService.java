package com.example.warehouse.Servis;

import com.example.warehouse.Entity.Category;
import com.example.warehouse.Model.CategoryDto;
import com.example.warehouse.Model.Result;
import com.example.warehouse.Repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {
    @Autowired
    CategoryRepository categoryRepository;

    public Result addCategoryService(CategoryDto category) {
        Category category1 = new Category();
        category1.setName(category.getName());
        Optional<Category> byId = categoryRepository.findById(category.getParent_category_id());
        if (byId.isPresent()) {
            category1.setParentCategory(byId.get());
        }
        category1.setActive(category.getActive());
        categoryRepository.save(category1);
        return new Result("Category qoshildi", true);
    }

    public List<Category> getCategoryService() {
        List<Category> all = categoryRepository.findAll();
        return all;
    }

    public Category getCategoryById(Integer id) {
        Optional<Category> byId = categoryRepository.findById(id);
        return byId.get();
    }

    public Result putCategory(Integer id, CategoryDto categoryDto) {
        Optional<Category> byId = categoryRepository.findById(id);
        if (byId.isPresent()) {
            Category category = byId.get();
            category.setName(categoryDto.getName());
            Optional<Category> categoryOptional = categoryRepository.findById(categoryDto.getParent_category_id());
            category.setParentCategory(categoryOptional.get());
            if (byId.isPresent()) {
                category.setParentCategory(categoryOptional.get());
            }
            category.setActive(categoryDto.getActive());
            categoryRepository.save(category);
            return new Result("Category qoshildi", true);
        }
        return new Result("Category qoshilmadi", false);
    }

    public Result deleteCategory(Integer id) {
        categoryRepository.deleteById(id);
        return new Result("Category ochirildi", true);
    }

}
