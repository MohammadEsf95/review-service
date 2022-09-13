package com.api.reviewservice.presentation.comment;

import com.api.reviewservice.application.comment.CommentService;
import com.api.reviewservice.application.comment.dto.CreateCommentDTO;
import com.api.reviewservice.presentation.responseentity.ResponseEntityUtil;
import com.api.reviewservice.presentation.responseentity.response.SuccessfulRequestResponseEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

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

    @GetMapping
    public ResponseEntity<Object> findAllByProductId(@RequestParam UUID productId) {
        return ResponseEntityUtil.generateSuccessfulRequestResponseEntity(
                new SuccessfulRequestResponseEntity<>(
                        commentService.findAllByProductId(productId)
                )
        );
    }

    @PatchMapping
    public ResponseEntity<Object> changeSubmitStatus(
            @RequestParam UUID commentId,
            @RequestParam String submitStatus
    ) {
        return ResponseEntityUtil.generateSuccessfulRequestResponseEntity(
                new SuccessfulRequestResponseEntity<>(
                        commentService.changeSubmitStatus(commentId, submitStatus)
                )
        );
    }
}
