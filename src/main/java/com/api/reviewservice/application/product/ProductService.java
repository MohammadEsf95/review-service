package com.api.reviewservice.application.product;

import com.api.reviewservice.application.product.dto.CreateProductDTO;
import com.api.reviewservice.application.product.dto.ProductDTO;
import com.api.reviewservice.application.util.pagination.PageDTO;
import com.api.reviewservice.application.util.responsedto.SuccessfulResponseDTO;
import org.springframework.data.domain.Pageable;

import java.util.UUID;

public interface ProductService {
    SuccessfulResponseDTO create(CreateProductDTO createProductDTO);

    PageDTO<ProductDTO> findAll(UUID providerId, Pageable pageable);
}
