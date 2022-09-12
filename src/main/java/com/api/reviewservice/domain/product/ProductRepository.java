package com.api.reviewservice.domain.product;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;
@Repository
public interface ProductRepository extends JpaRepository<Product, UUID> {
    List<Product> findAllByProviderId(UUID providerId, Pageable pageable);
}
