package com.api.reviewservice.domain.score;

import com.api.reviewservice.domain.BaseEntity;
import com.api.reviewservice.domain.SubmitStatus;
import com.api.reviewservice.domain.product.Product;

import javax.persistence.*;

@Entity
@Table(name = "scores")
public class Score extends BaseEntity {
    @Column(name = "number")
    private int number;

    @Enumerated(EnumType.STRING)
    @Column(name = "submit_status")
    private SubmitStatus submitStatus;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "product_id")
    private Product product;

    public Score() {
    }

    public Score(int number, SubmitStatus isSubmitted, Product product) {
        this.number = number;
        this.submitStatus = isSubmitted;
        this.product = product;
    }

    public int getNumber() {
        return number;
    }

    public SubmitStatus getSubmitStatus() {
        return submitStatus;
    }

    public Product getProduct() {
        return product;
    }


    public Score changeSubmitted(String submitStatus) {
        this.submitStatus = SubmitStatus.getFromString(submitStatus);
        return this;
    }

    @Override
    public String toString() {
        return "Score{" +
                "number=" + number +
                ", submitStatus=" + submitStatus +
                '}' + super.toString();
    }
}
