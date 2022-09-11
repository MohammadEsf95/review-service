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
        boolean showVotes,
        boolean showRatings,
        boolean hasComment,
        boolean hasVote
) {

    public static Product to(CreateProductDTO createProductDTO, Provider provider) {
        return new Product(
                provider,
                createProductDTO.showComments(),
                createProductDTO.showVotes(),
                createProductDTO.hasComment(),
                createProductDTO.hasVote()
        );
    }
}
