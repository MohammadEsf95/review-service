package com.api.reviewservice.domain.product;

import com.api.reviewservice.domain.BaseEntity;
import com.api.reviewservice.domain.comment.Comment;
import com.api.reviewservice.domain.provider.Provider;
import com.api.reviewservice.domain.vote.Vote;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Entity
@Table(name = "products")
public class Product extends BaseEntity {
    @ManyToOne
    @JoinColumn(name = "provider_id")
    private Provider provider;

    @Column(name = "show_comments")
    private boolean showComments;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "product")
    private Set<Comment> comments;

    @Column(name = "show_votes")
    private boolean showVotes;

    @Column(name = "has_comment")
    private boolean hasComment;

    @Column(name = "has_vote")
    private boolean hasVote;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "product")
    private Set<Vote> votes;

    public Product() {
    }

    public Product(Provider provider, boolean showComments, boolean showVotes, boolean hasComment, boolean hasVote) {
        this.provider = provider;
        this.showComments = showComments;
        this.showVotes = showVotes;
        this.hasComment = hasComment;
        this.hasVote = hasVote;
        this.comments = new HashSet<>();
        this.votes = new HashSet<>();
    }

    public Provider getProvider() {
        return provider;
    }

    public boolean isShowComments() {
        return showComments;
    }

    public Set<Comment> getComments() {
        return comments;
    }

    public boolean isShowVotes() {
        return showVotes;
    }

    public Set<Vote> getVotes() {
        return votes;
    }

    public boolean isHasComment() {
        return hasComment;
    }

    public boolean isHasVote() {
        return hasVote;
    }

    @Override
    public String toString() {
        return "Product{" +
                "provider=" + provider +
                ", showComments=" + showComments +
                ", showVotes=" + showVotes +
                ", hasComment=" + hasComment +
                ", hasVote=" + hasVote +
                '}' + super.toString();
    }
}
