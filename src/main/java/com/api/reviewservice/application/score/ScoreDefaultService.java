package com.api.reviewservice.application.score;

import com.api.reviewservice.application.util.responsedto.SuccessfulResponseDTO;
import com.api.reviewservice.application.score.dto.CreateScoreDTO;
import com.api.reviewservice.application.score.dto.ScoreDTO;
import com.api.reviewservice.domain.product.Product;
import com.api.reviewservice.domain.product.ProductRepository;
import com.api.reviewservice.domain.score.Score;
import com.api.reviewservice.domain.score.ScoreRepository;
import com.api.reviewservice.infrastructure.ApplicationMessages;
import com.api.reviewservice.infrastructure.exception.ExceptionMessages;
import com.api.reviewservice.infrastructure.exception.applicationexception.CannotSubmitScoreOrComment;
import com.api.reviewservice.infrastructure.exception.applicationexception.RecordNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Service
@Transactional
public class ScoreDefaultService implements ScoreService {

    private final ScoreRepository scoreRepository;
    private final ProductRepository productRepository;

    public ScoreDefaultService(ScoreRepository scoreRepository, ProductRepository productRepository) {
        this.scoreRepository = scoreRepository;
        this.productRepository = productRepository;
    }

    @Override
    public SuccessfulResponseDTO create(CreateScoreDTO createScoreDTO) {
        Product product = productRepository.findById(createScoreDTO.productId()).orElseThrow(
                () -> new RecordNotFoundException(ExceptionMessages.RECORD_NOT_FOUND.getTitle())
        );
        if (!product.isScoreable())
          throw new CannotSubmitScoreOrComment(ExceptionMessages.CANNOT_SUBMIT_SCORE_OR_COMMENT.getTitle());

        Score score = scoreRepository.save(
                CreateScoreDTO.to(createScoreDTO,product)
        );
        return new SuccessfulResponseDTO(score.getId(), ApplicationMessages.OPERATION_COMPLETED.getTitle());
    }

    @Override
    public List<ScoreDTO> findAllByProductId(UUID productId) {
        List<Score> scores = scoreRepository.findAllByProductId(productId);
        return ScoreDTO.from(scores);
    }

    @Override
    public SuccessfulResponseDTO submitOrRejectScore(UUID id, String submitStatus) {
        Score score = scoreRepository.findById(id).orElseThrow(
                () -> new RecordNotFoundException(ExceptionMessages.RECORD_NOT_FOUND.getTitle())
        );
        scoreRepository.save(
                score.changeSubmitted(submitStatus)
        );
        float averageScore = scoreRepository.calculateAverageScore(score.getProduct().getId());
        productRepository.save(
                score.getProduct().updateAverageScore(averageScore)
        );
        return new SuccessfulResponseDTO(ApplicationMessages.OPERATION_COMPLETED.getTitle());
    }
}
