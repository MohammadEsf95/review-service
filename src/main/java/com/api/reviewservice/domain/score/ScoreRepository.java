package com.api.reviewservice.domain.score;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;
@Repository
public interface ScoreRepository extends JpaRepository<Score, UUID> {
    List<Score> findAllByProductId(UUID productId);

    @Query(
            value = "select avg(number) as averageScore from scores where product_id = :id and submit_status = 'SUBMITTED'",
            nativeQuery = true
    )
    float calculateAverageScore(UUID id);
}
