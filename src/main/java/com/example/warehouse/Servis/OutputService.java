package com.example.warehouse.Servis;

import com.example.warehouse.Entity.*;
import com.example.warehouse.Model.OutputDto;
import com.example.warehouse.Model.Result;
import com.example.warehouse.Repository.ClientRepository;
import com.example.warehouse.Repository.CurrencyRepository;
import com.example.warehouse.Repository.OutputRepository;
import com.example.warehouse.Repository.WarehouseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class OutputService {
    @Autowired
    OutputRepository outputRepository;
    @Autowired
    private WarehouseRepository warehouseRepository;
    @Autowired
    private CurrencyRepository currencyRepository;
    @Autowired
    private ClientRepository clientRepository;

    public List<Output> getOutput() {
        return outputRepository.findAll();
    }

    public Result postOutput(OutputDto outputDto) {
        Output output = new Output();
        LocalDateTime dateCheck = getDateCheck(outputDto);
        Timestamp timestamp = Timestamp.valueOf(dateCheck);
        output.setDate(timestamp);
        Optional<Warehouse> byId = warehouseRepository.findById(outputDto.getWarehouseId());
        output.setWarehouse(byId.get());
        Optional<Currency> byId1 = currencyRepository.findById(outputDto.getCurrencyId());
        output.setCurrency(byId1.get());
        output.setFacturNumber(outputDto.getFactureNumber());
        Randoms random = new Randoms();
        output.setCode(random.getRandom());
        Optional<Client> client = clientRepository.findById(outputDto.getClientId());
        output.setClient(client.get());
        return new Result("Qoshildi",true);
    }

    private LocalDateTime getDateCheck(OutputDto outputDto) {
        LocalDateTime localDateTime = LocalDateTime.now();
        return localDateTime;
    }

    public Result putOutput(Integer id, OutputDto outputDto) {
        Optional<Output> byId = outputRepository.findById(id);
        if (byId.isPresent()) {
            Output output = byId.get();
            Date date = new Date();
            LocalDateTime dateCheck = getDateCheck(outputDto);
            Timestamp timestamp = Timestamp.valueOf(dateCheck);
            output.setDate(timestamp);
            Optional<Warehouse> warehouse = warehouseRepository.findById(outputDto.getWarehouseId());
            output.setWarehouse(warehouse.get());
            Optional<Currency> byId1 = currencyRepository.findById(outputDto.getCurrencyId());
            output.setCurrency(byId1.get());
            output.setFacturNumber(outputDto.getFactureNumber());
            Randoms random = new Randoms();
            output.setCode(random.getRandom());
            Optional<Client> client = clientRepository.findById(outputDto.getClientId());
            output.setClient(client.get());
            return new Result("Update",true);
        }
        return new Result("Bundau output topilmadi",true);
    }

    public Result deleteOutput(Integer id) {
        outputRepository.deleteById(id);
        return new Result("delete",true);
    }
}
