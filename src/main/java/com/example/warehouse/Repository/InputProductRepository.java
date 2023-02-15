package com.example.warehouse.Repository;

import com.example.warehouse.Entity.InputProduct;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InputProductRepository extends JpaRepository<InputProduct,Integer> {
}
