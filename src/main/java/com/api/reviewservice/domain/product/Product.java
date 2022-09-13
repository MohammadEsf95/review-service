package com.api.reviewservice.domain.product;

import com.api.reviewservice.domain.BaseEntity;
import com.api.reviewservice.domain.comment.Comment;
import com.api.reviewservice.domain.provider.Provider;
import com.api.reviewservice.domain.score.Score;

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

    @Column(name = "is_visible")
    private boolean isVisible;
    @Column(name = "show_comments")
    private boolean showComments;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "product")
    private Set<Comment> comments;

    @Column(name = "show_scores")
    private boolean showScores;

    @Column(name = "commentable")
    private boolean commentable;

    @Column(name = "scoreable")
    private boolean scoreable;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "product")
    private Set<Score> scores;

    public Product() {
    }

    public Product(String name, Provider provider, boolean isVisible, boolean showComments, boolean showScores, boolean hasComment, boolean scoreable) {
        this.name = name;
        this.provider = provider;
        this.isVisible = isVisible;
        this.showComments = showComments;
        this.showScores = showScores;
        this.commentable = hasComment;
        this.scoreable = scoreable;
        this.comments = new HashSet<>();
        this.scores = new HashSet<>();
    }

    public String getName() {
        return name;
    }

    public Provider getProvider() {
        return provider;
    }

    public boolean isVisible() {
        return isVisible;
    }

    public boolean isShowComments() {
        return showComments;
    }

    public Set<Comment> getComments() {
        return comments;
    }

    public boolean isShowScores() {
        return showScores;
    }

    public Set<Score> getScores() {
        return scores;
    }

    public boolean isCommentable() {
        return commentable;
    }

    public boolean isScoreable() {
        return scoreable;
    }
    public Product changeShow() {
        this.isVisible = !this.isVisible;
        return this;
    }

    public Product changeCommentableAndVotable(boolean commentable, boolean scoreable) {
        this.commentable = commentable;
        this.scoreable = scoreable;
        return this;
    }

    @Override
    public String toString() {
        return "Product{" +
                "provider=" + provider +
                ", isVisible=" + isVisible +
                ", showComments=" + showComments +
                ", showScores=" + showScores +
                ", hasComment=" + commentable +
                ", scoreable=" + scoreable +
                '}' + super.toString();
    }
}
