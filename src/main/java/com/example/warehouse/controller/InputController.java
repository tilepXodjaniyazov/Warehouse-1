package com.example.warehouse.controller;

import com.example.warehouse.Entity.Input;
import com.example.warehouse.Model.InputDto;
import com.example.warehouse.Model.Result;
import com.example.warehouse.Servis.InputService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public class InputController {
    @Autowired
    InputService inputService;
    @GetMapping
    public List<Input> getInput() {
        List<Input> input = inputService.getInput();
        return input;
    }

    @PostMapping
    public Result postInput(@RequestBody InputDto inputDto) {
        Result result = inputService.postInput(inputDto);
        return result;
    }
    @PutMapping("/{id}")
    public Result putInput(@PathVariable Integer id, @RequestBody InputDto inputDto) {
        Result result = inputService.putInput(id, inputDto);
        return result;
    }
    @DeleteMapping("/{id}")
    public Result deleteInput(@PathVariable Integer id) {
        Result result = inputService.deleteInout(id);
        return result;
    }
}
