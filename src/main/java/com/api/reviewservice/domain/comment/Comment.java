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

    public UUID getId() {
        return id;
    }

    public String getText() {
        return text;
    }

    public LocalDateTime getCreateDate() {
        return createDate;
    }

    public Product getProduct() {
        return product;
    }

    public boolean isSubmitted() {
        return isSubmitted;
    }

    @PrePersist
    private void onCreate() {
        this.id = UUID.randomUUID();
        this.createDate = LocalDateTime.now();
    }

    @Override
    public String toString() {
        return "Comment{" +
                "id=" + id +
                ", text='" + text + '\'' +
                ", createDate=" + createDate +
                ", product=" + product +
                ", isSubmitted=" + isSubmitted +
                '}';
    }
}
