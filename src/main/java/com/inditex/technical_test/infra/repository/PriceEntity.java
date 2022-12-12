package com.inditex.technical_test.infra.repository;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Data
@Table(name = "prices")
public class PriceEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;

  @Column(name = "brand_id")
  private int brandId;

  @Column(name = "start_date")
  private LocalDateTime startDate;

  @Column(name = "end_date")
  private LocalDateTime endDate;

  @Column(name = "price_list")
  private int priceList;
  
  @Column(name = "product_id")
  private int productId;

  @Column(name = "priority")
  private int priority;

  @Column(name = "price")
  private double price;

  @Column(name = "curr")
  private String currency;

}
