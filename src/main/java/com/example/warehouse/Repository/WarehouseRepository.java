package com.example.warehouse.Repository;

import com.example.warehouse.Entity.Warehouse;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WarehouseRepository extends JpaRepository<Warehouse,Integer> {
    Boolean deleteWarehouseById(Integer id);
}
