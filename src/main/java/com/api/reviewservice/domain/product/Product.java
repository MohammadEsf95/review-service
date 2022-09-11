package com.api.reviewservice.domain.product;

import com.api.reviewservice.domain.comment.Comment;
import com.api.reviewservice.domain.provider.Provider;
import com.api.reviewservice.domain.vote.Vote;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Set;
import java.util.UUID;

@Entity
@Table(name = "products")
public class Product {

    @Id
    private UUID id;

    @Column(name = "create_date", updatable = false)
    private LocalDateTime createDate;

    @ManyToOne
    @JoinColumn(name = "provider_id")
    private Provider provider;

    @Column(name = "show_comments")
    private boolean showComments;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "product")
    private Set<Comment> comments;

    @Column(name = "show_votes")
    private boolean showVotes;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "product")
    private Set<Vote> votes;

    public Product() {
    }
}
