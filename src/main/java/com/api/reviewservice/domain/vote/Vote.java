package com.api.reviewservice.domain.vote;

import com.api.reviewservice.domain.BaseEntity;
import com.api.reviewservice.domain.product.Product;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "votes")
public class Vote extends BaseEntity {
    @Column(name = "score")
    private int score;

    @Column(name = "is_submitted")
    private boolean isSubmitted;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

    public Vote() {
    }

    public Vote(int score, boolean isSubmitted, Product product) {
        this.score = score;
        this.isSubmitted = isSubmitted;
        this.product = product;
    }

    public int getScore() {
        return score;
    }

    public boolean isSubmitted() {
        return isSubmitted;
    }

    public Product getProduct() {
        return product;
    }

    @Override
    public String toString() {
        return "Vote{" +
                "score=" + score +
                ", isSubmitted=" + isSubmitted +
                ", product=" + product +
                '}' + super.toString();
    }
}
