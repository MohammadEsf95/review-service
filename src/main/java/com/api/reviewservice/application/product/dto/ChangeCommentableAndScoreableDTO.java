package com.api.reviewservice.application.product.dto;

import javax.validation.constraints.NotNull;
import java.util.UUID;

public record ChangeCommentableAndScoreableDTO(
        @NotNull UUID id,
        boolean commentable,
        boolean scoreable
) {
}
