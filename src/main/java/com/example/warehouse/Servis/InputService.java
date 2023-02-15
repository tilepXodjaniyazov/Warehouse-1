package com.example.warehouse.Servis;

import com.example.warehouse.Entity.Currency;
import com.example.warehouse.Entity.Input;
import com.example.warehouse.Entity.Supplier;
import com.example.warehouse.Entity.Warehouse;
import com.example.warehouse.Model.InputDto;
import com.example.warehouse.Model.Result;
import com.example.warehouse.Repository.CurrencyRepository;
import com.example.warehouse.Repository.InputRepository;
import com.example.warehouse.Repository.SupplierRepository;
import com.example.warehouse.Repository.WarehouseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class InputService {
    @Autowired
    InputRepository inputRepository;
    @Autowired
    WarehouseRepository warehouseRepository;
    @Autowired
    SupplierRepository supplierRepository;
    @Autowired
    CurrencyRepository currencyRepository;

    public List<Input> getInput() {
        List<Input> all = inputRepository.findAll();
        return all;
    }
    public Result postInput(InputDto inputDto) {
        Input input = new Input();
        Randoms randoms = new Randoms();
        input.setDate(randoms.getDateNow());
        Optional<Warehouse> byId = warehouseRepository.findById(inputDto.getWarehouseId());
        input.setWarehouse(byId.get());
        Optional<Supplier> supplier = supplierRepository.findById(inputDto.getSupplierId());
        input.setSupplier(supplier.get());
        Optional<Currency> currency = currencyRepository.findById(inputDto.getCurrencyId());
        input.setCurrency(currency.get());
        input.setFacturNumber(inputDto.getFacture_number());
        input.setCode(randoms.getRandom());
        inputRepository.save(input);
        return new Result("Qoshildi",true);
    }
    public Result putInput(Integer id,InputDto inputDto) {
        Optional<Input> byId = inputRepository.findById(id);
        if (byId.isPresent()) {
            Input input = byId.get();
            Randoms randoms = new Randoms();
            input.setDate(randoms.getDateNow());
            Optional<Warehouse> warehouse = warehouseRepository.findById(inputDto.getWarehouseId());
            input.setWarehouse(warehouse.get());
            Optional<Supplier> supplier = supplierRepository.findById(inputDto.getSupplierId());
            input.setSupplier(supplier.get());
            Optional<Currency> currency = currencyRepository.findById(inputDto.getCurrencyId());
            input.setCurrency(currency.get());
            input.setFacturNumber(inputDto.getFacture_number());
            input.setCode(randoms.getRandom());
            inputRepository.save(input);
            return new Result("Ozgardi",true);
        }
        return new Result("Bunday Input topilmadi",false);
    }
    public Result deleteInout(Integer id) {
        inputRepository.deleteById(id);
        return new Result("Ochirildi",true);
    }
}
