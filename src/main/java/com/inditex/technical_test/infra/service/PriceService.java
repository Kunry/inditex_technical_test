package com.inditex.technical_test.infra.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.inditex.technical_test.application.CustomDataNotFoundException;
import com.inditex.technical_test.controller.dto.PriceDTO;
import com.inditex.technical_test.domain.IPriceService;
import com.inditex.technical_test.infra.repository.IPriceRepository;
import com.inditex.technical_test.infra.repository.PriceEntity;

@Service
public class PriceService implements IPriceService {

  @Autowired
  private IPriceRepository priceRepository;

  /**
   * @param productId
   * @param brandId
   * @param date
   * @return
   * @throws CustomDataNotFoundException
   * @throws Exception
   * 
   */
  @Override
  public PriceDTO getProductBrandByDate(int productId, int brandId, LocalDateTime date) {
    List<PriceEntity> prices = priceRepository.findPriceByProductIdAndBrandIdAndDate(productId, brandId, date);

    PriceEntity price = prices.stream().findFirst().orElse(null);
    if (price == null) {
      throw new CustomDataNotFoundException("Price not found");
    }
    return new PriceDTO().mappPriceDTO(price);

  }
}
