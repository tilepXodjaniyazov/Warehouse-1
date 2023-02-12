package com.example.warehouse.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Input_productDto {
    private Integer productId;
    private Double amount;
    private Double price;
    private Date expireData;
    private Integer inputId;
}
