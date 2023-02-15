package com.example.warehouse.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class InputDto {
    private Integer warehouseId;
    private Integer supplierId;
    private Integer currencyId;
    private String facture_number;
    private String code;
}
