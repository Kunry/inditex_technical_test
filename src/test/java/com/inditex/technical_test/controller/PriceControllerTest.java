package com.inditex.technical_test.controller;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class PriceControllerTest {

  @Autowired
  private MockMvc mockMvc;
  

  @Test
  @DisplayName("Test 1: petición a las 10:00 del día 14 del producto 35455 para la brand 1 (ZARA)")
  public void testGetPrices1() throws Exception {
    mockMvc.perform(
        get("/prices?date={date}&productId={productId}&brandId={brandId}", "2020-06-14T10:00:00.000Z", "35455", "1"))
        .andExpect(status().isOk()).andExpect(jsonPath("$.price").value(35.5));
  }

  @Test
  @DisplayName("Test 2: petición a las 16:00 del día 14 del producto 35455 para la brand 1 (ZARA)")
  public void testGetPrices2() throws Exception {
    mockMvc.perform(
        get("/prices?date={date}&productId={productId}&brandId={brandId}", "2020-06-14T16:00:00.000Z", "35455", "1"))
        .andExpect(status().isOk()).andExpect(jsonPath("$.price").value(35.5));
  }

  @Test
  @DisplayName("Test 3: petición a las 21:00 del día 14 del producto 35455 para la brand 1 (ZARA)")
  public void testGetPrices3() throws Exception {
    mockMvc.perform(
        get("/prices?date={date}&productId={productId}&brandId={brandId}", "2020-06-14T21:00:00.000Z", "35455", "1"))
        .andExpect(status().isOk()).andExpect(jsonPath("$.price").value(35.5));
  }

  @Test
  @DisplayName("Test 4: petición a las 10:00 del día 15 del producto 35455   para la brand 1 (ZARA)")
  public void testGetPrices4() throws Exception {
    mockMvc.perform(
        get("/prices?date={date}&productId={productId}&brandId={brandId}", "2020-06-15T10:00:00.000Z", "35455", "1"))
        .andExpect(status().isOk()).andExpect(jsonPath("$.price").value(30.5));
  }

  @Test
  @DisplayName("Test 5: petición a las 21:00 del día 16 del producto 35455 para la brand 1 (ZARA)")
  public void testGetPrices5() throws Exception {
    mockMvc.perform(
        get("/prices?date={date}&productId={productId}&brandId={brandId}", "2020-06-16T21:00:00.000Z", "35455", "1"))
        .andExpect(status().isOk()).andExpect(jsonPath("$.price").value(38.95));
  }

  @Test
  @DisplayName("Test 6: petición a las 01:00 del día 10 del producto 35455 para la brand 1 (ZARA)")
  public void testGetPrices6() throws Exception {
    mockMvc.perform(
        get("/prices?date={date}&productId={productId}&brandId={brandId}", "2020-06-10T10:00:00.000Z", "35455", "1"))
        .andExpect(status().isNotFound());
  }
}