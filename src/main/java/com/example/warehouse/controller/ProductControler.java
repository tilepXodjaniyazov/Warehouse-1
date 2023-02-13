package com.example.warehouse.controller;

import com.example.warehouse.Entity.Product;
import com.example.warehouse.Model.ProductDto;
import com.example.warehouse.Model.Result;
import com.example.warehouse.Servis.ProductServis;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductControler {
    @Autowired
    ProductServis productServis;
    @PostMapping
    public Result addProduct(@RequestBody ProductDto productDto) {
        return productServis.postProduct(productDto);
    }
    @PutMapping("/{id}")
    public Result putProduct(@PathVariable Integer id, @RequestBody ProductDto productDto) {
        return productServis.putProduct(id,productDto);
    }
    @DeleteMapping("/{id}")
    public Result deleteProduct(@PathVariable Integer id) {
        return productServis.deleteProduct(id);
    }
    @GetMapping
    public List<Product> getProduct() {
        List<Product> product = productServis.getProduct();
        return product;
    }
    @GetMapping("/{id}")
    public Result getProductId(@PathVariable Integer id) {
        return productServis.getProductId(id);
    }
}
