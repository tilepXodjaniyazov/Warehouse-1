package com.example.warehouse.controller;

import com.example.warehouse.Entity.Output;
import com.example.warehouse.Entity.OutputProduct;
import com.example.warehouse.Model.OutputDto;
import com.example.warehouse.Model.OutputProductDto;
import com.example.warehouse.Model.Result;
import com.example.warehouse.Servis.OutputProductService;
import com.example.warehouse.Servis.OutputService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class OutputController {
    @Autowired
    OutputService outputService;
    @GetMapping
    public List<Output> getOutput() {
        List<Output> output = outputService.getOutput();
        return output;
    }
    @PutMapping("/{id}")
    public Result putOutput(@PathVariable Integer id, @RequestBody OutputDto outputDto) {
        return outputService.putOutput(id, outputDto);
    }
    @PostMapping
    public Result postOutput(@RequestBody OutputDto outputProductDto) {
        return outputService.postOutput(outputProductDto);
    }
    @DeleteMapping("/{id}")
    public Result deleteOutput(@PathVariable Integer id) {
        return outputService.deleteOutput(id);
    }
}
