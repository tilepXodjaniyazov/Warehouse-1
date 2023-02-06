package com.example.warehouse.Entity;

import com.example.warehouse.Entity.tamplate.AbsEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Product extends AbsEntity {
    @ManyToOne
    private Category category;
    @OneToOne
    private Attachment attachment;
    @Column(unique = true,nullable = true)
    private String code;
    @ManyToOne
    private Measurement measurement;
}
