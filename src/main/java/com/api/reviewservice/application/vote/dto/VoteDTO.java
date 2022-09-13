package com.api.reviewservice.application.vote.dto;

import com.api.reviewservice.domain.vote.Vote;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

public record VoteDTO(
        UUID id,
        LocalDateTime createDate,
        int score,
        boolean isSubmitted
) {
    public static List<VoteDTO> from(List<Vote> votes) {
        return votes.stream().map(VoteDTO::from).collect(Collectors.toList());
    }

    public static VoteDTO from(Vote vote) {
        return new VoteDTO(
                vote.getId(),
                vote.getCreateDate(),
                vote.getScore(),
                vote.isSubmitted()
        );
    }
}
