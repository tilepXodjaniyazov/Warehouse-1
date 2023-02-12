package com.example.warehouse.controller;

import com.example.warehouse.Entity.Supplier;
import com.example.warehouse.Model.Result;
import com.example.warehouse.Model.SupplierDto;
import com.example.warehouse.Servis.SupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/supplier")
public class SupplierController {
    @Autowired
    SupplierService supplierService;

    @GetMapping
    public List<Supplier> getSupplier() {
        List<Supplier> result = supplierService.getSupplier();
        return result;
    }

    @GetMapping("/{id}")
    public Supplier getSupplierById(@PathVariable Integer id) {
        Supplier supplier = supplierService.getSupplierById(id);
        return supplier;
    }

    @PostMapping
    public Result postSupplier(@RequestBody SupplierDto supplierDto) {
        return supplierService.postSupplier(supplierDto);
    }

    @PutMapping("/{id}")
    public Result putSupplier(@PathVariable Integer id, @RequestBody SupplierDto supplierDto) {
        return supplierService.putSupplier(id, supplierDto);
    }

    @DeleteMapping("/{id}")
    public Result deleteSupplier(@PathVariable Integer id) {
        Result result = supplierService.deleteSupplier(id);
        if (result != null) {
            return result;
        } else {
            return new Result("Bunday Supplier topilmadi",false);
        }
    }

}
