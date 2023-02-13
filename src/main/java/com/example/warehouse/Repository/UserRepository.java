package com.example.warehouse.Repository;

import com.example.warehouse.Entity.User;
import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UserRepository extends JpaRepository<User,Integer> {
    boolean findUserByPhone_number();
}
