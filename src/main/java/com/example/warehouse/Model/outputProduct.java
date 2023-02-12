package com.example.warehouse.Model;

import com.example.warehouse.Entity.Output;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class outputProduct {
    private Integer productId;
    private Double amount;
    private Double price;
    private Integer outputId;
}
