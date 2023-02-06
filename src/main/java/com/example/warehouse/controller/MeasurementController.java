package com.example.warehouse.controller;

import com.example.warehouse.Entity.Measurement;
import com.example.warehouse.Model.Result;
import com.example.warehouse.Servis.MeasurementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/measurement")
public class MeasurementController {
    @Autowired
    MeasurementService measurementServis;
    @PostMapping
    public Result addMeasurementController(@RequestBody Measurement measurement) {
        Result result = measurementServis.addMeasurementService(measurement);
        return result;
    }

    @GetMapping("/{id}")
    public Measurement getMeasurementIdController(@PathVariable Integer id) {
        Measurement measurement = measurementServis.getMeasurementByIdService(id);
        return measurement;
    }

    @GetMapping
    public List<Measurement> getAllMeasurement() {
        return measurementServis.getMeasurementAllService();
    }

    @DeleteMapping("/{id}")
    public Result deleteMeasurement(@PathVariable Integer id) {
        Result result = measurementServis.deleteMeasurementService(id);
        return result;
    }
    @PutMapping("/{id}")
    public Result updataMeasurement(@PathVariable String id,@RequestBody Measurement measurement) {

    }


}
