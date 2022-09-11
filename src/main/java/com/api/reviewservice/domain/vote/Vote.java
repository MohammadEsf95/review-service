package com.api.reviewservice.domain.vote;

import com.api.reviewservice.domain.product.Product;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "votes")
public class Vote {

    @Id
    private UUID id;

    @Column(name = "create_date", updatable = false)
    private LocalDateTime createDate;

    @Column(name = "score")
    private int score;

    @Column(name = "is_submitted")
    private boolean isSubmitted;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

    public Vote() {
    }
}
