package com.api.reviewservice.application.comment;

import com.api.reviewservice.application.comment.dto.CreateCommentDTO;
import com.api.reviewservice.application.util.responsedto.SuccessfulResponseDTO;

public interface CommentService {
    SuccessfulResponseDTO create(CreateCommentDTO createCommentDTO);
}
