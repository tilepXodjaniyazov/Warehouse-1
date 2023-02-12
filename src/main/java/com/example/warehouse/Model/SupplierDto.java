package com.example.warehouse.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SupplierDto {
    private String name;
    private Boolean actve;
    private String phoneNumber;
}
