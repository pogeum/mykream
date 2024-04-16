package com.kream.chouxkream.product.repository;

import com.kream.chouxkream.product.model.entity.ProductSize;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface ProductSizeRepository extends JpaRepository<ProductSize, Long> {

    @Query("SELECT ps FROM ProductSize ps WHERE ps.product.productNo = :productNo")
    List<ProductSize> findByProductNo(@Param("productNo") Long productNo);

    Optional<ProductSize> findById(Long productSizeNo);
}