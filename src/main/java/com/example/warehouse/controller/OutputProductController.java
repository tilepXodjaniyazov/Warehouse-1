package com.example.warehouse.controller;

import com.example.warehouse.Entity.OutputProduct;
import com.example.warehouse.Model.OutputProductDto;
import com.example.warehouse.Model.Result;
import com.example.warehouse.Servis.OutputProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public class OutputProductController {
    @Autowired
     OutputProductService outputProductService;
    @GetMapping
    public List<OutputProduct> getOutputProduct() {
        List<OutputProduct> outputProduct = outputProductService.getOutputProduct();
        return outputProduct;
    }
    @PutMapping("/{id}")
    public Result putOutputProduct(@PathVariable Integer id, @RequestBody OutputProductDto outputProductDto) {
        return outputProductService.putOutputProduct(id, outputProductDto);
    }
    @PostMapping
    public Result postOutputProduct(@RequestBody OutputProductDto outputProductDto) {
        return outputProductService.postOutputProduct(outputProductDto);
    }
    @DeleteMapping("/{id}")
    public Result deleteOutputProduct(@PathVariable Integer id) {
        return outputProductService.deleteOutputProduct(id);
    }
}
