package com.api.reviewservice.application.product;

import com.api.reviewservice.application.product.dto.CreateProductDTO;
import com.api.reviewservice.application.util.responsedto.SuccessfulResponseDTO;

public interface ProductService {
    SuccessfulResponseDTO create(CreateProductDTO createProductDTO);
}
