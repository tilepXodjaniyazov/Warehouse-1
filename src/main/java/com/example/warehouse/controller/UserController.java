package com.example.warehouse.controller;

import com.example.warehouse.Entity.User;
import com.example.warehouse.Model.Result;
import com.example.warehouse.Model.UserDto;
import com.example.warehouse.Repository.CurrencyRepository;
import com.example.warehouse.Servis.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("user")
public class UserController {
    @Autowired
    UserService userService;
    @Autowired
    private CurrencyRepository currencyRepository;

    @GetMapping
    public List<User> getCurrencyAll() {
        return userService.getUserAll();
    }
    @GetMapping("/{id}")
    public User getCurrencyById(@PathVariable Integer id) {
        User userById = userService.getUserById(id);
        return userById;
    }

    @PostMapping
    public Result postCurrency(@RequestBody UserDto userDto) {
        Result result = userService.postUser(userDto);
        return result;
    }
    @PutMapping("/{id}")
    public Result putCurrency(@PathVariable Integer id, UserDto userDto) {
        Result result = userService.putUser(id, userDto);
        return result;
    }

    @DeleteMapping("/{id}")
    public Result deleteCurrency(@PathVariable Integer id) {
        Result result = userService.deleteUser(id);
        return result;
    }

}
