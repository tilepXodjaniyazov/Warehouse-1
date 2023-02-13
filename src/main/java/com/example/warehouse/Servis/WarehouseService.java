package com.example.warehouse.Servis;

import com.example.warehouse.Entity.User;
import com.example.warehouse.Entity.Warehouse;
import com.example.warehouse.Model.Result;
import com.example.warehouse.Model.UserDto;
import com.example.warehouse.Repository.WarehouseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class WarehouseService {
    @Autowired
    WarehouseRepository warehouseRepository;
    public List<Warehouse> getWarehouseAll() {
        List<Warehouse> all = warehouseRepository.findAll();
        return all;
    }

    public Warehouse getWarehouseById(Integer id) {
        Optional<Warehouse> byId = warehouseRepository.findById(id);
        return byId.get();
    }

    public Result postWarehouse(Warehouse warehouseDto) {
        Warehouse warehouse = new Warehouse();
        warehouse.setName(warehouseDto.getName());
        warehouse.setActive(warehouseDto.getActive());
        warehouseRepository.save(warehouse);
        return new Result("Qoshildi ",true);
    }

    public Result putWarehouse(Integer id, Warehouse warehouse) {
        Optional<Warehouse> byId = warehouseRepository.findById(id);
        if (byId.isPresent()) {
            Warehouse warehouse1 = byId.get();
            warehouse1.setName(warehouse.getName());
            warehouse1.setActive(warehouse.getActive());
            warehouseRepository.save(warehouse);
            return new Result("Ozgartilidi",true);
        }
        return new Result("qoshilmadi",false);
    }

    public Result deleteWarehouse(Integer id) {
        Boolean aBoolean = warehouseRepository.deleteWarehouseById(id);
        return new Result("ochirildi",aBoolean);
    }
}
