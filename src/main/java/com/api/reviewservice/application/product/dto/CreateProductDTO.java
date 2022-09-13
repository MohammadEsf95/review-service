package com.api.reviewservice.application.product.dto;

import com.api.reviewservice.domain.product.Product;
import com.api.reviewservice.domain.provider.Provider;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.UUID;

public record CreateProductDTO(
        @NotEmpty String name,
        @NotNull UUID providerId,
        boolean show,
        boolean showComments,
        boolean showScores,
        boolean showRatings,
        boolean commentable,
        boolean scoreable
) {

    public static Product to(CreateProductDTO createProductDTO, Provider provider) {
        return new Product(
                createProductDTO.name(),
                provider,
                false,
                createProductDTO.showComments(),
                createProductDTO.showScores(),
                createProductDTO.commentable(),
                createProductDTO.scoreable()
        );
    }
}
