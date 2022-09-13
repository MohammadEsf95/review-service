package com.api.reviewservice.application.score.dto;

import com.api.reviewservice.domain.SubmitStatus;
import com.api.reviewservice.domain.product.Product;
import com.api.reviewservice.domain.score.Score;

import javax.validation.constraints.NotNull;
import java.util.UUID;

public record CreateScoreDTO(
        @NotNull int score,
        @NotNull UUID productId
        ) {
    public static Score to(CreateScoreDTO createScoreDTO, Product product) {
        return new Score(
                createScoreDTO.score(),
                SubmitStatus.NOT_SPECIFIED,
                product
        );
    }
}
