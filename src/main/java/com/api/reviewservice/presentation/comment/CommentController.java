package com.api.reviewservice.presentation.comment;

import com.api.reviewservice.application.comment.CommentService;
import com.api.reviewservice.application.comment.dto.CreateCommentDTO;
import com.api.reviewservice.presentation.responseentity.ResponseEntityUtil;
import com.api.reviewservice.presentation.responseentity.response.SuccessfulRequestResponseEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/comment")
public class CommentController {

    private final CommentService commentService;

    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }

    @PostMapping
    public ResponseEntity<Object> create(@RequestBody CreateCommentDTO createCommentDTO) {
        return ResponseEntityUtil.generateSuccessfulRequestResponseEntity(
                new SuccessfulRequestResponseEntity<>(
                        commentService.create(createCommentDTO)
                )
        );
    }
}