package com.api.reviewservice.domain.comment;

import com.api.reviewservice.domain.BaseEntity;
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

    @Column(name = "is_submitted")
    private boolean isSubmitted;

    public Comment() {
    }

    public Comment(String text, Product product, boolean isSubmitted) {
        this.text = text;
        this.product = product;
        this.isSubmitted = isSubmitted;
    }

    public String getText() {
        return text;
    }

    public Product getProduct() {
        return product;
    }

    public boolean isSubmitted() {
        return isSubmitted;
    }

    public Comment changeSubmitted() {
        this.isSubmitted = !this.isSubmitted;
        return this;
    }

    @Override
    public String toString() {
        return "Comment{" +
                "text='" + text +
                ", product=" + product +
                ", isSubmitted=" + isSubmitted +
                '}' + super.toString();
    }
}
