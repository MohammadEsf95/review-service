package com.api.reviewservice.domain.comment;

import com.api.reviewservice.domain.product.Product;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "comments")
public class Comment {

    @Id
    private UUID id;

    @Column(name = "text")
    private String text;

    @Column(name = "create_date", updatable = false)
    private LocalDateTime createDate;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

    @Column(name = "is_submitted")
    private boolean isSubmitted;

    public Comment() {
    }
}
