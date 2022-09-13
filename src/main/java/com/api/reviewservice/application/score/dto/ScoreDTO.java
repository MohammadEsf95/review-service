package com.api.reviewservice.application.score.dto;

import com.api.reviewservice.domain.SubmitStatus;
import com.api.reviewservice.domain.score.Score;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

public record ScoreDTO(
        UUID id,
        LocalDateTime createDate,
        int number,
        SubmitStatus isSubmitted
) {
    public static List<ScoreDTO> from(List<Score> scores) {
        return scores.stream().map(ScoreDTO::from).collect(Collectors.toList());
    }

    public static ScoreDTO from(Score score) {
        return new ScoreDTO(
                score.getId(),
                score.getCreateDate(),
                score.getNumber(),
                score.getSubmitStatus()
        );
    }
}
