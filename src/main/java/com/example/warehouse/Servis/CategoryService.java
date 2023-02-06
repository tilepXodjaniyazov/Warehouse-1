package com.example.warehouse.Servis;

import com.example.warehouse.Entity.Category;
import com.example.warehouse.Model.Result;
import com.example.warehouse.Repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {
    @Autowired
    CategoryRepository categoryRepository;

    public Result addCategoryService(Category category) {
        categoryRepository.save(category);
        return new Result("Category qoshildi",true);
    }
    public List<Category> getCategoryService() {
        List<Category> all = categoryRepository.findAll();
        return all;
    }
    public Category getCategoryById(Integer id) {
        Optional<Category> byId = categoryRepository.findById(id);
        return byId.get();
    }

    public void
}
