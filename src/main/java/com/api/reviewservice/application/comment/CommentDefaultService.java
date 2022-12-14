package com.api.reviewservice.application.comment;

import com.api.reviewservice.application.comment.dto.CommentDTO;
import com.api.reviewservice.application.comment.dto.CreateCommentDTO;
import com.api.reviewservice.application.util.responsedto.SuccessfulResponseDTO;
import com.api.reviewservice.domain.comment.Comment;
import com.api.reviewservice.domain.comment.CommentRepository;
import com.api.reviewservice.domain.product.Product;
import com.api.reviewservice.domain.product.ProductRepository;
import com.api.reviewservice.infrastructure.ApplicationMessages;
import com.api.reviewservice.infrastructure.exception.ExceptionMessages;
import com.api.reviewservice.infrastructure.exception.applicationexception.CannotSubmitScoreOrComment;
import com.api.reviewservice.infrastructure.exception.applicationexception.RecordNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class CommentDefaultService implements CommentService {

    private final CommentRepository commentRepository;
    private final ProductRepository productRepository;

    public CommentDefaultService(CommentRepository commentRepository, ProductRepository productRepository) {
        this.commentRepository = commentRepository;
        this.productRepository = productRepository;
    }

    @Override
    public SuccessfulResponseDTO create(CreateCommentDTO createCommentDTO) {
        Product product  = productRepository.findById(createCommentDTO.productId()).orElseThrow(
                () -> new RecordNotFoundException(ExceptionMessages.RECORD_NOT_FOUND.getTitle())
        );
        if (!product.isCommentable())
            throw new CannotSubmitScoreOrComment(ExceptionMessages.CANNOT_SUBMIT_SCORE_OR_COMMENT.getTitle());
        Comment comment = commentRepository.save(
                CreateCommentDTO.to(createCommentDTO, product)
        );
        return new SuccessfulResponseDTO(comment.getId(), ApplicationMessages.OPERATION_COMPLETED.getTitle());
    }

    @Override
    public List<CommentDTO> findAllByProductId(UUID productId) {
        List<Comment> comments = commentRepository.findAllByProductId(productId);
        return CommentDTO.from(comments);
    }

    @Override
    public List<CommentDTO> findLastThreeByProductId(UUID productId) {
        List<Comment> comments = commentRepository.findLastThreeByProductId(productId);
        return CommentDTO.from(comments);
    }

    @Override
    public SuccessfulResponseDTO changeSubmitStatus(UUID commentId, String submitStatus) {
        Comment comment = commentRepository.findById(commentId).orElseThrow(
                () -> new RecordNotFoundException(ExceptionMessages.RECORD_NOT_FOUND.getTitle())
        );
        commentRepository.save(
                comment.changeSubmitted(submitStatus)
        );
        return new SuccessfulResponseDTO(ApplicationMessages.OPERATION_COMPLETED.getTitle());
    }
}
