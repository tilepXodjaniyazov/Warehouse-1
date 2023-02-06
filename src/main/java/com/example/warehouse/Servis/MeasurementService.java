package com.example.warehouse.Servis;

import com.example.warehouse.Entity.Measurement;
import com.example.warehouse.Model.Result;
import com.example.warehouse.Repository.MeasurementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MeasurementService {
    @Autowired
    MeasurementRepository measurementRepository;
    public Result addMeasurementService(Measurement measurement) {
        boolean existsByName = measurementRepository.existsByName(measurement.getName());
        if (existsByName)
            return new Result("Bunday olchov birligi mavjud",false);
         measurementRepository.save(measurement);
         return new Result("Measurement qoshildi",true);

    }

    public List<Measurement> getMeasurementAllService() {
        List<Measurement> all = measurementRepository.findAll();
        return all;
    }

    public Measurement getMeasurementByIdService(Integer id) {
        Optional<Measurement> byId = measurementRepository.findById(id);
        return byId.get();
    }

    public Result deleteMeasurementService(Integer id) {
        measurementRepository.deleteById(id);
        return new Result("delete Measurement",true);
    }

}