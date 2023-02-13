package com.example.warehouse.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class OutputDto {
    private Date date;
    private Integer warehouseId;
    private Integer currencyId;
    private String factureNumber;
    private String code;
    private Integer clientId;
}
