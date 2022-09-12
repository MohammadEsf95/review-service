package com.api.reviewservice.application.product.dto;

import com.api.reviewservice.domain.product.Product;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

public record ProductDTO(
        UUID id,
        String name,
        LocalDateTime createDate,
        LocalDateTime updateDate,
        boolean hasComments,
        boolean hasVotes
) {

    public static List<ProductDTO> from(List<Product> products) {
        return products.stream().map(ProductDTO::from).collect(Collectors.toList());
    }
    public static ProductDTO from(Product product) {
        return new ProductDTO(
                product.getId(),
                product.getName(),
                product.getCreateDate(),
                product.getUpdateDate(),
                product.isCommentable(),
                product.isVotable()
        );
    }
}
