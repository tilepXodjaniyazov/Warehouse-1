package com.example.warehouse.Servis;

import com.example.warehouse.Entity.Output;
import com.example.warehouse.Entity.OutputProduct;
import com.example.warehouse.Entity.Product;
import com.example.warehouse.Model.OutputProductDto;
import com.example.warehouse.Model.Result;
import com.example.warehouse.Repository.OutputProductRepository;
import com.example.warehouse.Repository.OutputRepository;
import com.example.warehouse.Repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OutputProductService {
    @Autowired
    OutputProductRepository outputProductRepository;
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private OutputRepository outputRepository;

    public List<OutputProduct> getOutputProduct() {
        List<OutputProduct> all = outputProductRepository.findAll();
        return all;
    }
    public Result postOutputProduct(OutputProductDto outputProductDto) {
        OutputProduct outputProduct = new OutputProduct();
        Optional<Product> byId = productRepository.findById(outputProductDto.getProductId());
        outputProduct.setProduct(byId.get());
        outputProduct.setAmount(outputProductDto.getAmount());
        outputProduct.setPrice(outputProductDto.getPrice());
        Optional<Output> byId1 = outputRepository.findById(outputProductDto.getOutputId());
        outputProduct.setOutput(byId1.get());
        outputProductRepository.save(outputProduct);
        return new Result("Qoshildi",true);
    }

    public Result putOutputProduct(Integer id,OutputProductDto outputProductDto) {
        Optional<OutputProduct> byIds = outputProductRepository.findById(id);
        if (byIds.isPresent()) {
            OutputProduct outputProduct = byIds.get();
            Optional<Product> byId = productRepository.findById(outputProductDto.getProductId());
            outputProduct.setProduct(byId.get());
            outputProduct.setAmount(outputProductDto.getAmount());
            outputProduct.setPrice(outputProductDto.getPrice());
            Optional<Output> byId1 = outputRepository.findById(outputProductDto.getOutputId());
            outputProduct.setOutput(byId1.get());
            outputProductRepository.save(outputProduct);
            return new Result("Ozgardi",true);
        }
        return new Result("Bunday OutputProduct topilmadi",false);
    }

    public Result deleteOutputProduct(Integer id) {
        outputProductRepository.deleteById(id);
        return new Result("Ochirildi",true);
    }
}
