package com.api.reviewservice.domain.vote;

import com.api.reviewservice.domain.BaseEntity;
import com.api.reviewservice.domain.SubmitStatus;
import com.api.reviewservice.domain.product.Product;

import javax.persistence.*;

@Entity
@Table(name = "votes")
public class Vote extends BaseEntity {
    @Column(name = "score")
    private int score;

    @Enumerated(EnumType.STRING)
    @Column(name = "submit_status")
    private SubmitStatus submitStatus;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

    public Vote() {
    }

    public Vote(int score, SubmitStatus isSubmitted, Product product) {
        this.score = score;
        this.submitStatus = isSubmitted;
        this.product = product;
    }

    public int getScore() {
        return score;
    }

    public SubmitStatus getSubmitStatus() {
        return submitStatus;
    }

    public Product getProduct() {
        return product;
    }


    public Vote changeSubmitted(String submitStatus) {
        this.submitStatus = SubmitStatus.getFromString(submitStatus);
        return this;
    }

    @Override
    public String toString() {
        return "Vote{" +
                "score=" + score +
                ", submitStatus=" + submitStatus +
                ", product=" + product +
                '}' + super.toString();
    }
}
