package com.api.reviewservice.application.vote;

import com.api.reviewservice.application.util.responsedto.SuccessfulResponseDTO;
import com.api.reviewservice.application.vote.dto.CreateVoteDTO;

public interface VoteService {
    SuccessfulResponseDTO create(CreateVoteDTO createVoteDTO);
}
