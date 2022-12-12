package com.inditex.technical_test.domain;

import java.time.LocalDateTime;

import com.inditex.technical_test.controller.dto.PriceDTO;

public interface IPriceService {
  public PriceDTO getProductBrandByDate(int productId, int brandId, LocalDateTime date);
}
