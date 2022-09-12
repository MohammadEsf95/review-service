package com.api.reviewservice.application.vote.dto;

import com.api.reviewservice.domain.product.Product;
import com.api.reviewservice.domain.vote.Vote;

import javax.validation.constraints.NotNull;
import java.util.UUID;

public record CreateVoteDTO(
        @NotNull int score,
        @NotNull UUID productId
        ) {
    public static Vote to(CreateVoteDTO createVoteDTO, Product product) {
        return new Vote(
                createVoteDTO.score(),
                false,
                product
        );
    }
}
