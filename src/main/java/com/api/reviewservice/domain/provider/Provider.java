package com.api.reviewservice.domain.provider;

import com.api.reviewservice.domain.product.Product;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Set;
import java.util.UUID;

@Entity
@Table(name = "providers")
public class Provider {

    @Id
    private UUID id;

    @Column(name = "create_date", updatable = false)
    private LocalDateTime createDate;

    @Column(name = "name")
    private String name;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "provider")
    private Set<Product> products;

    public Provider(String name) {
        this.name = name;
    }

    public Provider() {
    }

    public UUID getId() {
        return id;
    }

    public LocalDateTime getCreateDate() {
        return createDate;
    }

    public String getName() {
        return name;
    }

    public Set<Product> getProducts() {
        return products;
    }

    @PrePersist
    private void onCreate() {
        this.id = UUID.randomUUID();
        this.createDate = LocalDateTime.now();
    }

    @Override
    public String toString() {
        return "Provider{" +
                "id=" + id +
                ", createDate=" + createDate +
                ", name='" + name + '\'' +
                '}';
    }
}
