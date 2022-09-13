package com.api.reviewservice.application.comment.dto;

import com.api.reviewservice.domain.SubmitStatus;
import com.api.reviewservice.domain.comment.Comment;
import com.api.reviewservice.domain.product.Product;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.UUID;

public record CreateCommentDTO(
        @NotEmpty String text,
        @NotNull UUID productId
        ) {
    public static Comment to(CreateCommentDTO createCommentDTO, Product product) {
        return new Comment(
                createCommentDTO.text(),
                product,
                SubmitStatus.NOT_SPECIFIED
        );
    }
}
