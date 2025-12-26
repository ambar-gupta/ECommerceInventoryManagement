package com.ambar.InventoryService.entity;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "inventory_batch")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class InventoryBatch {

    @Id
    @Column(name = "batch_id")
    private Long batchId;

    @Column(name = "product_id")
    private Long productId;

    @Column(name = "product_name")
    private String productName;

    @Column(name = "quantity")
    private Integer quantity;

    @Column(name = "expiry_date")
    private LocalDate expiryDate;
    
    @Column(name = "created_date")
    private LocalDate createdDate;

}


