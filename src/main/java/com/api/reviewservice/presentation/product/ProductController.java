package com.api.reviewservice.presentation.product;

import com.api.reviewservice.application.product.ProductService;
import com.api.reviewservice.application.product.dto.ChangeCommentableAndScoreableDTO;
import com.api.reviewservice.application.product.dto.CreateProductDTO;
import com.api.reviewservice.application.util.pagination.PaginationDTO;
import com.api.reviewservice.presentation.responseentity.ResponseEntityUtil;
import com.api.reviewservice.presentation.responseentity.response.SuccessfulRequestResponseEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping(path = "/product")
public class ProductController {
    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping
    public ResponseEntity<Object> create(@RequestBody CreateProductDTO createProductDTO) {
        return ResponseEntityUtil.generateSuccessfulRequestResponseEntity(
                new SuccessfulRequestResponseEntity<>(
                        productService.create(createProductDTO)
                )
        );
    }

    @GetMapping
    public ResponseEntity<Object> findAll(
            @RequestParam(required = false, defaultValue = "1") int page,
            @RequestParam(required = false, defaultValue = "10") int size,
            @RequestParam UUID providerId
            ) {
        return ResponseEntityUtil.generateSuccessfulRequestResponseEntity(
                new SuccessfulRequestResponseEntity<>(
                        productService.findAll(
                                providerId,
                                PaginationDTO.pageableByUpdateDate(page, size)
                        )
                )
        );
    }

    @PatchMapping(path = "show-hide/{id}")
    public ResponseEntity<Object> showOrHideProduct(@PathVariable UUID id) {
        return ResponseEntityUtil.generateSuccessfulRequestResponseEntity(
                new SuccessfulRequestResponseEntity<>(
                        productService.showOrHideProduct(id)
                )
        );
    }

    @PatchMapping(path = "commentable-scoreable")
    public ResponseEntity<Object> changeCommentableAndVotable(
            @RequestBody ChangeCommentableAndScoreableDTO changeCommentableAndScoreableDTO
    ) {
        return ResponseEntityUtil.generateSuccessfulRequestResponseEntity(
                new SuccessfulRequestResponseEntity<>(
                        productService.changeCommentableAndVotable(changeCommentableAndScoreableDTO)
                )
        );
    }
}
