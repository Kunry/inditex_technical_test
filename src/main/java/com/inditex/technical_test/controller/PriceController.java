package com.inditex.technical_test.controller;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.inditex.technical_test.application.CustomDataNotFoundException;
import com.inditex.technical_test.controller.dto.PriceDTO;
import com.inditex.technical_test.infra.service.PriceService;

import jakarta.validation.ValidationException;

@RestController
@RequestMapping("/")
public class PriceController {

  @Autowired
  PriceService priceService;

  /**
   * @param date
   * @param productId
   * @param brandId
   * @return
   */
  @GetMapping("/prices")
  @ResponseBody
  public ResponseEntity<PriceDTO> getPrice(
      @RequestParam("date") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime date,
      @RequestParam("productId") String productId,
      @RequestParam("brandId") String brandId) {

    PriceDTO price = priceService.getProductBrandByDate(Integer.parseInt(productId),
        Integer.parseInt(brandId), date);
    return ResponseEntity.ok(price);
  }

  @ExceptionHandler(CustomDataNotFoundException.class)
  public ResponseEntity<String> handleValidationException(ValidationException e) {
    HttpStatus status = HttpStatus.NOT_FOUND;
    return ResponseEntity
        .status(status)
        .body("error");
  }

}
