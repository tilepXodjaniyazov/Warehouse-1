package com.example.warehouse.Repository;

import com.example.warehouse.Entity.Supplier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface SupplierRepository extends JpaRepository<Supplier,Integer> {
    Supplier findByNameOrPhoneNumber(String name, String phoneNumber);
}
