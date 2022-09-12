package com.api.reviewservice.domain.provider;

import com.api.reviewservice.domain.BaseEntity;
import com.api.reviewservice.domain.product.Product;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Set;
import java.util.UUID;

@Entity
@Table(name = "providers")
public class Provider extends BaseEntity {

    @Column(name = "name")
    private String name;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "provider")
    private Set<Product> products;

    public Provider(String name) {
        this.name = name;
    }

    public Provider() {
    }

    public String getName() {
        return name;
    }

    public Set<Product> getProducts() {
        return products;
    }

    @Override
    public String toString() {
        return "Provider{" +
                "name='" + name + '\'' +
                ", products=" + products +
                '}' + super.toString();
    }
}
