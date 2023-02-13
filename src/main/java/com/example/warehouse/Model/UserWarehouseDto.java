package com.example.warehouse.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserWarehouseDto {
    private Integer userId;
    private Integer warehouseId;
}
