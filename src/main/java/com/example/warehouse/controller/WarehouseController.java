package com.example.warehouse.controller;

import com.example.warehouse.Entity.User;
import com.example.warehouse.Entity.Warehouse;
import com.example.warehouse.Model.Result;
import com.example.warehouse.Model.UserDto;
import com.example.warehouse.Servis.WarehouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public class WarehouseController {
    @Autowired
    WarehouseService warehouseService;
    @GetMapping
    public List<Warehouse> getWarehouseAll() {
        return warehouseService.getWarehouseAll();
    }
    @GetMapping("/{id}")
    public Warehouse getWarehouseById(@PathVariable Integer id) {
        return warehouseService.getWarehouseById(id);
    }

    @PostMapping
    public Result postWarehouse(@RequestBody Warehouse warehouse) {
        Result result = warehouseService.postWarehouse(warehouse);
        return result;
    }
    @PutMapping("/{id}")
    public Result putWarehouse(@PathVariable Integer id, Warehouse warehouse) {
        Result result = warehouseService.putWarehouse(id, warehouse);
        return result;
    }

    @DeleteMapping("/{id}")
    public Result deleteWarehouse(@PathVariable Integer id) {
        Result result = warehouseService.deleteWarehouse(id);
        return result;
    }
}
