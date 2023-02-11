package com.example.warehouse.Model;

import com.example.warehouse.Servis.MeasurementService;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductDto {
    private String name;
    private Integer categoryId;
    private Integer photoId;
    private String code;
    private Integer measurementId;
    private Boolean active = true;
}
