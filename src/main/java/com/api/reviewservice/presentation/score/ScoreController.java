package com.api.reviewservice.presentation.score;

import com.api.reviewservice.application.score.ScoreService;
import com.api.reviewservice.application.score.dto.CreateScoreDTO;
import com.api.reviewservice.presentation.responseentity.ResponseEntityUtil;
import com.api.reviewservice.presentation.responseentity.response.SuccessfulRequestResponseEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping(path = "/score")
public class ScoreController {

    private final ScoreService scoreService;

    public ScoreController(ScoreService scoreService) {
        this.scoreService = scoreService;
    }

    @PostMapping
    public ResponseEntity<Object> create(@RequestBody CreateScoreDTO createScoreDTO) {
        return ResponseEntityUtil.generateSuccessfulRequestResponseEntity(
                new SuccessfulRequestResponseEntity<>(
                        scoreService.create(createScoreDTO)
                )
        );
    }

    @GetMapping
    public ResponseEntity<Object> findAllByProductId(@RequestParam UUID productId) {
        return ResponseEntityUtil.generateSuccessfulRequestResponseEntity(
                new SuccessfulRequestResponseEntity<>(
                        scoreService.findAllByProductId(productId)
                )
        );
    }

    @PatchMapping
    public ResponseEntity<Object> submitOrRejectScore(
            @RequestParam UUID id,
            @RequestParam String submitStatus
            ) {
        return ResponseEntityUtil.generateSuccessfulRequestResponseEntity(
                new SuccessfulRequestResponseEntity<>(
                        scoreService.submitOrRejectScore(id, submitStatus)
                )
        );
    }

}
