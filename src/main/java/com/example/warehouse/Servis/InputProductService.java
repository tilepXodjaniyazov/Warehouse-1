package com.example.warehouse.Servis;

import com.example.warehouse.Entity.Input;
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
        Optional<Input> input = inputRepository.findById(inputProductDto.getInputId());
        inputProduct.setInput(input.get());
        return new Result("Qoshildi",true);
    }

    public Result putInputProduct(Integer id, Input_productDto inputProductDto) {
        Optional<InputProduct> byId = inputProductRepository.findById(id);
        if (byId.isPresent()) {
            InputProduct inputProduct = byId.get();
            Optional<Product> product = productRepository.findById(inputProductDto.getProductId());
            inputProduct.setProduct(product.get());
            inputProduct.setAmount(inputProductDto.getAmount());
            inputProduct.setPrice(inputProductDto.getPrice());
            inputProduct.setExpireData(inputProduct.getExpireData());
            Optional<Input> input = inputRepository.findById(inputProductDto.getInputId());
            inputProduct.setInput(input.get());
            return new Result("Ozgardi",true);
        }
        return new Result("Bunday inputProduct topilmadi",false);
    }

    public Result deleteInoutProduct(Integer id) {
        inputProductRepository.deleteById(id);
        return new Result("Ochirildi",true);
    }
}
