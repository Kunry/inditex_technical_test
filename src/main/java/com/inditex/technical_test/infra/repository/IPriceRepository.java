package com.inditex.technical_test.infra.repository;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface IPriceRepository extends JpaRepository<PriceEntity, Long> {

  @Query(value = "SELECT * FROM PRICES p WHERE p.product_id = :productId AND p.brand_id = :brandId AND p.start_date <= :date AND p.end_date >= :date ORDER BY p.priority DESC", nativeQuery = true)

  List<PriceEntity> findPriceByProductIdAndBrandIdAndDate(@Param("productId") int productId,
      @Param("brandId") int brandId, @Param("date") LocalDateTime date);
}