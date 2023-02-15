package com.example.warehouse.controller;

import com.example.warehouse.Entity.Input;
import com.example.warehouse.Entity.InputProduct;
import com.example.warehouse.Model.InputDto;
import com.example.warehouse.Model.Input_productDto;
import com.example.warehouse.Model.Result;
import com.example.warehouse.Servis.InputProductService;
import com.example.warehouse.Servis.InputService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public class InputProductController {
    @Autowired
    InputProductService inputProductService;
    @GetMapping
    public List<InputProduct> getInput() {
        List<InputProduct> inputProduct = inputProductService.getInputProduct();
        return inputProduct;
    }

    @PostMapping
    public Result postInput(@RequestBody Input_productDto inputProductDto) {
        Result result = inputProductService.postInputProduct(inputProductDto);
        return result;
    }
    @PutMapping("/{id}")
    public Result putInput(@PathVariable Integer id, @RequestBody Input_productDto inputProductDto) {
        Result result = inputProductService.putInputProduct(id, inputProductDto);
        return result;
    }
    @DeleteMapping("/{id}")
    public Result deleteInput(@PathVariable Integer id) {
        Result result = inputProductService.deleteInoutProduct(id);
        return result;
    }
}
