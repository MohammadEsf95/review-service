package com.api.reviewservice.presentation.vote;

import com.api.reviewservice.application.vote.VoteService;
import com.api.reviewservice.application.vote.dto.CreateVoteDTO;
import com.api.reviewservice.presentation.responseentity.ResponseEntityUtil;
import com.api.reviewservice.presentation.responseentity.response.SuccessfulRequestResponseEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping(path = "/vote")
public class VoteController {

    private final VoteService voteService;

    public VoteController(VoteService voteService) {
        this.voteService = voteService;
    }

    @PostMapping
    public ResponseEntity<Object> create(@RequestBody CreateVoteDTO createVoteDTO) {
        return ResponseEntityUtil.generateSuccessfulRequestResponseEntity(
                new SuccessfulRequestResponseEntity<>(
                        voteService.create(createVoteDTO)
                )
        );
    }

    @GetMapping
    public ResponseEntity<Object> findAllByProductId(@RequestParam UUID productId) {
        return ResponseEntityUtil.generateSuccessfulRequestResponseEntity(
                new SuccessfulRequestResponseEntity<>(
                        voteService.findAllByProductId(productId)
                )
        );
    }

    @PatchMapping
    public ResponseEntity<Object> submitOrRejectVote(
            @RequestParam UUID voteId,
            @RequestParam String submitStatus
            ) {
        return ResponseEntityUtil.generateSuccessfulRequestResponseEntity(
                new SuccessfulRequestResponseEntity<>(
                        voteService.submitOrRejectVote(voteId, submitStatus)
                )
        );
    }

}
