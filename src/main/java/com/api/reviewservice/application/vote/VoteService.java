package com.api.reviewservice.application.vote;

import com.api.reviewservice.application.comment.dto.CommentDTO;
import com.api.reviewservice.application.util.responsedto.SuccessfulResponseDTO;
import com.api.reviewservice.application.vote.dto.CreateVoteDTO;
import com.api.reviewservice.application.vote.dto.VoteDTO;

import java.util.List;
import java.util.UUID;

public interface VoteService {
    SuccessfulResponseDTO create(CreateVoteDTO createVoteDTO);

    List<VoteDTO> findAllByProductId(UUID productId);

    SuccessfulResponseDTO submitOrRejectVote(UUID voteId, String submitStatus);
}
