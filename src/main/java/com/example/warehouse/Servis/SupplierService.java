package com.example.warehouse.Servis;

import com.example.warehouse.Entity.Supplier;
import com.example.warehouse.Model.Result;
import com.example.warehouse.Model.SupplierDto;
import com.example.warehouse.Repository.SupplierRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SupplierService {
    @Autowired
    SupplierRepository supplierRepository;

    public SupplierService(SupplierRepository supplierRepository) {
        this.supplierRepository = supplierRepository;
    }

    public List<Supplier> getSupplier() {
        return supplierRepository.findAll();
    }

    public Supplier getSupplierById(Integer id) {
        return supplierRepository.findById(id).get();
    }

    public Result postSupplier(SupplierDto supplierDto) {
        Supplier aBoolean = checkSupplier(supplierDto);
        if (aBoolean == null) {
            Supplier supplier = new Supplier();
            supplier.setName(supplierDto.getName());
            supplier.setPhoneNumber(supplierDto.getPhoneNumber());
            supplier.setActive(supplierDto.getActve());
            Supplier save = supplierRepository.save(supplier);
            return new Result("Qoshildi "+save.getName(),true);
        }
        return new Result("Qoshilmadi",false);
    }

    private Supplier checkSupplier(SupplierDto supplierDto) {
        return supplierRepository.findByNameOrPhoneNumber(supplierDto.getName(), supplierDto.getPhoneNumber());
    }


    public Result putSupplier(Integer id, SupplierDto supplierDto) {
        Optional<Supplier> byId = supplierRepository.findById(id);
        if (byId.isPresent()) {
            Supplier supplier = byId.get();
            supplier.setName(supplierDto.getName());
            supplier.setPhoneNumber(supplierDto.getPhoneNumber());
            supplier.setActive(supplierDto.getActve());
            Supplier save = supplierRepository.save(supplier);
            return new Result("Qoshildi "+save.getName(),true);
        }
        return null;
    }

    public Result deleteSupplier(Integer id) {
        try {
            supplierRepository.deleteById(id);
            return new Result("Delete supplier",true);
        } catch (Throwable e) {
            return new Result("Bunday Supplier topilmadi",false);
        }
    }
}
