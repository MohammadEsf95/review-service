package com.api.reviewservice.domain.comment;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;
@Repository
public interface CommentRepository extends JpaRepository<Comment, UUID> {
    List<Comment> findAllByProductId(UUID productId);
    @Query(
            value = "select * from comments where product_id = :productId and submit_status = 'SUBMITTED' order by update_date desc limit 3",
            nativeQuery = true
    )
    List<Comment> findLastThreeByProductId(UUID productId);
}
