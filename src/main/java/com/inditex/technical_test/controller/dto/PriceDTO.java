package com.inditex.technical_test.controller.dto;

import java.time.LocalDateTime;

import com.inditex.technical_test.infra.repository.PriceEntity;

import lombok.Data;

@Data
public class PriceDTO {
  private int product_id;
  private int brand_id;
  private int price_list;
  private double price;
  private LocalDateTime start_date;
  private LocalDateTime end_date;

  /**
   * @param priceEntity
   * @return
   */
  public PriceDTO mappPriceDTO (PriceEntity priceEntity) {
    PriceDTO priceDTO = new PriceDTO();
    priceDTO.setProduct_id(priceEntity.getProductId());
    priceDTO.setBrand_id(priceEntity.getBrandId());
    priceDTO.setPrice_list(priceEntity.getPriceList());
    priceDTO.setPrice(priceEntity.getPrice());
    priceDTO.setStart_date(priceEntity.getStartDate());
    priceDTO.setEnd_date(priceEntity.getEndDate());

    return priceDTO;
  }
}
