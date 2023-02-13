package com.example.warehouse.controller;

import com.example.warehouse.Model.CurrencyDto;
import com.example.warehouse.Model.Result;
import com.example.warehouse.Repository.CurrencyRepository;
import com.example.warehouse.Servis.CurrencyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("currency")
public class CurrencyController {
    @Autowired
    CurrencyService currencyService;
    @Autowired
    private CurrencyRepository currencyRepository;

    @GetMapping
    public Result getCurrencyAll() {
       Result currency = currencyService.getCurrencyAll();
       return currency;
    }
    @GetMapping("/{id}")
    public Result getCurrencyById(@PathVariable Integer id) {
        Result currencyById = currencyService.getCurrencyById(id);
        return currencyById;
    }
    
    @PostMapping
    public Result postCurrency(@RequestBody CurrencyDto currencyDto) {
        Result result = currencyService.postCurrency(currencyDto);
        return result;
    }
    @PutMapping("/{id}")
    public Result putCurrency(@PathVariable Integer id, CurrencyDto currencyDto) {
        Result result = currencyService.putCurrency(id, currencyDto);
        return result;
    }

    @DeleteMapping("/{id}")
    public Result deleteCurrency(@PathVariable Integer id) {
        Result result = currencyService.deleteCurrency(id);
        return result;
    }

}
