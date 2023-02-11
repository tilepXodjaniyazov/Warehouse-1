package com.example.warehouse.Servis;

import com.example.warehouse.Entity.Attachment;
import com.example.warehouse.Entity.Category;
import com.example.warehouse.Entity.Measurement;
import com.example.warehouse.Entity.Product;
import com.example.warehouse.Model.ProductDto;
import com.example.warehouse.Model.Result;
import com.example.warehouse.Repository.CategoryRepository;
import com.example.warehouse.Repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServis {
    @Autowired
    CategoryService categoryService;
    @Autowired
    AttachmentService attachmentService;
    @Autowired
    private CategoryRepository categoryRepository;
    @Autowired
    private MeasurementService measurementService;
    @Autowired
    private ProductRepository productRepository;

    public Result postProduct(ProductDto productDto) {
        Product product = new Product();
        product.setName(productDto.getName());
//        Category
        Category category = categoryService.getCategoryById(productDto.getCategoryId());
        product.setCategory(category);
        //photo
        Attachment fileById = attachmentService.getFileById(productDto.getPhotoId());
        if (fileById == null) {
            return new Result("bunday faile topilmadi",false);
        }
        product.setAttachment(fileById);
//       code Randoms
        Randoms randoms = new Randoms();
        String random = randoms.getRandom();
        product.setCode(random);
//        Measurement
        Measurement measurement = measurementService.getMeasurementByIdService(productDto.getMeasurementId());
        product.setMeasurement(measurement);
        productRepository.save(product);
        return new Result("Product qoshildi", true);
    }

    public Result putProduct(Integer id, ProductDto productDto) {
        Optional<Product> byId = productRepository.findById(id);
        if (byId.isPresent()) {
            Product product = byId.get();
            product.setName(productDto.getName());
//        Category
            Category category = categoryService.getCategoryById(productDto.getCategoryId());
            product.setCategory(category);
            //photo
            Attachment fileById = attachmentService.getFileById(productDto.getPhotoId());
            if (fileById == null) {
                return new Result("bunday faile topilmadi",false);
            }
            product.setAttachment(fileById);
//       code Randoms
            Randoms randoms = new Randoms();
            String random = randoms.getRandom();
            product.setCode(random);
//        Measurement
            Measurement measurement = measurementService.getMeasurementByIdService(productDto.getMeasurementId());
            product.setMeasurement(measurement);
            productRepository.save(product);
            return new Result("Product ozgardi", true);
        }
        return new Result("product ozgartirilmadi",false);
    }

    public Result getProductId(Integer id) {
        Optional<Product> byId = productRepository.findById(id);
        Product product = byId.get();
        return new Result("Product topildi"+product.getName(),true,product);
    }
    public List<Product> getProduct() {
        List<Product> all = productRepository.findAll();
        return all;
    }
    public Result deleteProduct(Integer id) {
        productRepository.deleteById(id);
        return new Result("Product ochirildi",true);
    }
}
