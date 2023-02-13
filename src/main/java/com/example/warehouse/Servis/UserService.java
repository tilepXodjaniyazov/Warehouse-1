package com.example.warehouse.Servis;

import com.example.warehouse.Entity.User;
import com.example.warehouse.Entity.Warehouse;
import com.example.warehouse.Model.Result;
import com.example.warehouse.Model.UserDto;
import com.example.warehouse.Repository.UserRepository;
import com.example.warehouse.Repository.WarehouseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;
    @Autowired
    private WarehouseRepository warehouseRepository;

    public List<User> getUserAll() {
        return userRepository.findAll();
    }

    public User getUserById(Integer id) {
        return userRepository.findById(id).get();
    }

    public Result postUser(UserDto userDto) {
        Randoms randoms = new Randoms();
        String random = randoms.getRandom();
        Optional<Warehouse> byId = warehouseRepository.findById(userDto.getWarehouseId());
        User user = new User();
        user.setFirst_name(userDto.getFirstName());
        user.setLast_name(userDto.getLastName());
        user.setPhone_number(userDto.getPhoneNumber());
        user.setCode(random);
        user.setPassword(userDto.getPassword());
        user.setActive(userDto.getActive());
        Set<Warehouse> warehouseSet = new HashSet<>();
        warehouseSet.add(byId.get());
        user.setWarehouse(warehouseSet);
        User save = userRepository.save(user);
        if (save != null) {
            return new Result("qoshildi", true);
        }
        return new Result("qoshilmadi", false);
    }


    public Result putUser(Integer id, UserDto userDto) {
        Optional<User> byId = userRepository.findById(id);
        if (byId.isPresent()) {
            Optional<Warehouse> warehouse = warehouseRepository.findById(userDto.getWarehouseId());
            User user = byId.get();
            user.setFirst_name(userDto.getFirstName());
            user.setLast_name(userDto.getLastName());
            user.setPhone_number(userDto.getPhoneNumber());
            user.setCode(user.getCode());
            user.setPassword(userDto.getPassword());
            user.setActive(userDto.getActive());
            Set<Warehouse> warehouseSet = new HashSet<>();
            warehouseSet.add(warehouse.get());
            user.setWarehouse(warehouseSet);
            User save = userRepository.save(user);
            return new Result("qoshildi", true);
        }
        return new Result("qoshilmadi", false);
    }

    public Result deleteUser(Integer id) {
        userRepository.deleteById(id);
        return new Result("ochirildi",true);
    }
}
