package com.api.reviewservice.application.product.dto;

import java.util.UUID;

public record ChangeCommentableAndVotableDTO(
        UUID id,
        boolean commentable,
        boolean votable
) {
}
