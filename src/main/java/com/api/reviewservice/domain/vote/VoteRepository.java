package com.api.reviewservice.domain.vote;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;
@Repository
public interface VoteRepository extends JpaRepository<Vote, UUID> {
}
