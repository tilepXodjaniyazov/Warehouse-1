package com.example.warehouse.Servis;

import com.example.warehouse.Entity.InputProduct;
import com.example.warehouse.Entity.Product;
import com.example.warehouse.Model.Input_productDto;
import com.example.warehouse.Model.Result;
import com.example.warehouse.Repository.InputProductRepository;
import com.example.warehouse.Repository.InputRepository;
import com.example.warehouse.Repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class InputProductService {
    @Autowired
    InputProductRepository inputProductRepository;
    @Autowired
    ProductRepository productRepository;
    @Autowired
    InputRepository inputRepository;
    public List<InputProduct> getInputProduct() {
        List<InputProduct> all = inputProductRepository.findAll();
        return all;
    }

    public Result postInputProduct(Input_productDto inputProductDto) {
        InputProduct inputProduct = new InputProduct();
        Optional<Product> byId = productRepository.findById(inputProductDto.getProductId());
        inputProduct.setProduct(byId.get());
        inputProduct.setAmount(inputProductDto.getAmount());
        inputProduct.setPrice(inputProductDto.getPrice());
        inputProduct.setExpireData(inputProduct.getExpireData());
        innput
        inputProduct.setInput();
        return null;
    }

    public Result putInputProduct(Integer id, Input_productDto inputProductDto) {
        return null;
    }

    public Result deleteInoutProduct(Integer id) {
        return null;
    }
}
