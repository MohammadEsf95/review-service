package com.api.reviewservice.application.score;

import com.api.reviewservice.application.util.responsedto.SuccessfulResponseDTO;
import com.api.reviewservice.application.score.dto.CreateScoreDTO;
import com.api.reviewservice.application.score.dto.ScoreDTO;

import java.util.List;
import java.util.UUID;

public interface ScoreService {
    SuccessfulResponseDTO create(CreateScoreDTO createScoreDTO);

    List<ScoreDTO> findAllByProductId(UUID productId);

    SuccessfulResponseDTO submitOrRejectScore(UUID id, String submitStatus);
}
