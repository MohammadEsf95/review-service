package com.api.reviewservice.domain.comment;

import com.api.reviewservice.domain.BaseEntity;
import com.api.reviewservice.domain.SubmitStatus;
import com.api.reviewservice.domain.product.Product;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "comments")
public class Comment extends BaseEntity {
    @Column(name = "text")
    private String text;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

    @Enumerated(EnumType.STRING)
    @Column(name = "submit_status")
    private SubmitStatus submitStatus;

    public Comment() {
    }

    public Comment(String text, Product product, SubmitStatus submitStatus) {
        this.text = text;
        this.product = product;
        this.submitStatus = submitStatus;
    }

    public String getText() {
        return text;
    }

    public Product getProduct() {
        return product;
    }

    public SubmitStatus getSubmitStatus() {
        return submitStatus;
    }

    public Comment changeSubmitted(String submitStatus) {
        this.submitStatus = SubmitStatus.getFromString(submitStatus);
        return this;
    }

    @Override
    public String toString() {
        return "Comment{" +
                "text='" + text +
                ", product=" + product +
                ", submitStatus=" + submitStatus +
                '}' + super.toString();
    }
}
