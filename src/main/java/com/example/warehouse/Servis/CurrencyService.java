package com.example.warehouse.Servis;

import com.example.warehouse.Entity.Currency;
import com.example.warehouse.Model.CurrencyDto;
import com.example.warehouse.Model.Result;
import com.example.warehouse.Repository.CurrencyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CurrencyService {
    @Autowired
    CurrencyRepository currencyRepository;
    public Result getCurrencyAll() {
        List<Currency> all = currencyRepository.findAll();
        return new Result("Currency xamasin berdi",true,all);
    }

    public Result getCurrencyById(Integer id) {
        Optional<Currency> byId = currencyRepository.findById(id);
        return new Result("Currency id orqoli olindi",true,byId.get());
    }

    public Result postCurrency(CurrencyDto currencyDto) {
        Currency currency = new Currency();
        currency.setName(currencyDto.getName());
        currency.setActive(currencyDto.getActive());
        currencyRepository.save(currency);
        return new Result("Qoshildi",true);
    }

    public Result putCurrency(Integer id, CurrencyDto currencyDto) {
        Optional<Currency> byId = currencyRepository.findById(id);
        if (byId.isPresent()) {
            Currency currency = byId.get();
            currency.setName(currencyDto.getName());
            currency.setActive(currencyDto.getActive());
            currencyRepository.save(currency);
            return new Result("Almashtirildi",true);
        }
        return new Result("Currency topilmadi",false);
    }

    public Result deleteCurrency(Integer id) {
        currencyRepository.deleteById(id);
        return new Result("Ochirildi",true);
    }
}
