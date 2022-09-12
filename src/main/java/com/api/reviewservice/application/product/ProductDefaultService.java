package com.api.reviewservice.application.product;

import com.api.reviewservice.application.product.dto.CreateProductDTO;
import com.api.reviewservice.application.product.dto.ProductDTO;
import com.api.reviewservice.application.util.pagination.PageDTO;
import com.api.reviewservice.application.util.responsedto.SuccessfulResponseDTO;
import com.api.reviewservice.domain.product.Product;
import com.api.reviewservice.domain.product.ProductRepository;
import com.api.reviewservice.domain.provider.Provider;
import com.api.reviewservice.domain.provider.ProviderRepository;
import com.api.reviewservice.infrastructure.ApplicationMessages;
import com.api.reviewservice.infrastructure.exception.ExceptionMessages;
import com.api.reviewservice.infrastructure.exception.applicationexception.RecordNotFoundException;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class ProductDefaultService implements ProductService {

    private final ProductRepository productRepository;
    private final ProviderRepository providerRepository;

    public ProductDefaultService(ProductRepository productRepository, ProviderRepository providerRepository) {
        this.productRepository = productRepository;
        this.providerRepository = providerRepository;
    }

    @Override
    public SuccessfulResponseDTO create(CreateProductDTO createProductDTO) {
        Provider provider = providerRepository.findById(createProductDTO.providerId()).orElseThrow(
                () -> new RecordNotFoundException(ExceptionMessages.RECORD_NOT_FOUND.getTitle())
        );
        Product product = productRepository.save(
                CreateProductDTO.to(createProductDTO, provider)
        );
        return new SuccessfulResponseDTO(product.getId(), ApplicationMessages.OPERATION_COMPLETED.getTitle());
    }

    @Override
    public PageDTO<ProductDTO> findAll(UUID providerId, Pageable pageable) {
        List<Product> products = productRepository.findAllByProviderId(providerId, pageable);
        return new PageDTO<>(
                ProductDTO.from(products),
                productRepository.count()
        );
    }
}
