package com.api.reviewservice.application.comment;

import com.api.reviewservice.application.comment.dto.CommentDTO;
import com.api.reviewservice.application.comment.dto.CreateCommentDTO;
import com.api.reviewservice.application.util.responsedto.SuccessfulResponseDTO;

import java.util.List;
import java.util.UUID;

public interface CommentService {
    SuccessfulResponseDTO create(CreateCommentDTO createCommentDTO);

    List<CommentDTO> findAllByProductId(UUID productId);

    List<CommentDTO> findLastThreeByProductId(UUID productId);

    SuccessfulResponseDTO changeSubmitStatus(UUID commentId, String submitStatus);
}
