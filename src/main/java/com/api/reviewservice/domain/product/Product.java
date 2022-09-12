package com.api.reviewservice.domain.product;

import com.api.reviewservice.domain.BaseEntity;
import com.api.reviewservice.domain.comment.Comment;
import com.api.reviewservice.domain.provider.Provider;
import com.api.reviewservice.domain.vote.Vote;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "products")
public class Product extends BaseEntity {

    @Column(name = "name")
    private String name;
    @ManyToOne
    @JoinColumn(name = "provider_id")
    private Provider provider;

    @Column(name = "show_comments")
    private boolean showComments;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "product")
    private Set<Comment> comments;

    @Column(name = "show_votes")
    private boolean showVotes;

    @Column(name = "commentable")
    private boolean commentable;

    @Column(name = "votable")
    private boolean votable;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "product")
    private Set<Vote> votes;

    public Product() {
    }

    public Product(String name, Provider provider, boolean showComments, boolean showVotes, boolean hasComment, boolean votable) {
        this.name = name;
        this.provider = provider;
        this.showComments = showComments;
        this.showVotes = showVotes;
        this.commentable = hasComment;
        this.votable = votable;
        this.comments = new HashSet<>();
        this.votes = new HashSet<>();
    }

    public String getName() {
        return name;
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

    public boolean isCommentable() {
        return commentable;
    }

    public boolean isVotable() {
        return votable;
    }

    @Override
    public String toString() {
        return "Product{" +
                "provider=" + provider +
                ", showComments=" + showComments +
                ", showVotes=" + showVotes +
                ", hasComment=" + commentable +
                ", hasVote=" + votable +
                '}' + super.toString();
    }
}
