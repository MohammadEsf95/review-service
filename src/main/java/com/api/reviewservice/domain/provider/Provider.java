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

    public Provider() {
    }
}
