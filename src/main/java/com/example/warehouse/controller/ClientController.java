package com.example.warehouse.controller;

import com.example.warehouse.Entity.Client;
import com.example.warehouse.Entity.tamplate.AbsEntity;
import com.example.warehouse.Model.ClientDto;
import com.example.warehouse.Model.Result;
import com.example.warehouse.Servis.ClientService;
import jakarta.persistence.Entity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/client")
public class ClientController {
    @Autowired
    ClientService clientService;
    @GetMapping
    public List<Client> getClient() {
        List<Client> clint = clientService.getClint();
        return clint;
    }

    @PostMapping
    public Result postClient(@RequestBody ClientDto clientDto) {
        clientService.postClient(clientDto);
        return new Result();
    }
    @PutMapping("/{id}")
    public Result putClient(@PathVariable Integer id,@RequestBody ClientDto clientDto) {
        return clientService.putClient(id,clientDto);
    }
    @DeleteMapping("/{id}")
    public Result deleteClient(@PathVariable Integer id) {
        return clientService.deleteClient(id);
    }

}
