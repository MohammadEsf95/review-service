package com.api.reviewservice.application.comment.dto;

import com.api.reviewservice.domain.SubmitStatus;
import com.api.reviewservice.domain.comment.Comment;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

public record CommentDTO(
        UUID id,
        LocalDateTime createDate,
        String text,
        SubmitStatus submitStatus
) {
    public static List<CommentDTO> from(List<Comment> comments) {
        return comments.stream().map(CommentDTO::from).collect(Collectors.toList());
    }

    public static CommentDTO from(Comment comment) {
        return new CommentDTO(
                comment.getId(),
                comment.getCreateDate(),
                comment.getText(),
                comment.getSubmitStatus()
        );
    }
}
