package com.api.reviewservice.application.vote;

import com.api.reviewservice.application.util.responsedto.SuccessfulResponseDTO;
import com.api.reviewservice.application.vote.dto.CreateVoteDTO;
import com.api.reviewservice.application.vote.dto.VoteDTO;
import com.api.reviewservice.domain.product.Product;
import com.api.reviewservice.domain.product.ProductRepository;
import com.api.reviewservice.domain.vote.Vote;
import com.api.reviewservice.domain.vote.VoteRepository;
import com.api.reviewservice.infrastructure.ApplicationMessages;
import com.api.reviewservice.infrastructure.exception.ExceptionMessages;
import com.api.reviewservice.infrastructure.exception.applicationexception.RecordNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class VoteDefaultService implements VoteService {

    private final VoteRepository voteRepository;
    private final ProductRepository productRepository;

    public VoteDefaultService(VoteRepository voteRepository, ProductRepository productRepository) {
        this.voteRepository = voteRepository;
        this.productRepository = productRepository;
    }

    @Override
    public SuccessfulResponseDTO create(CreateVoteDTO createVoteDTO) {
        Product product = productRepository.findById(createVoteDTO.productId()).orElseThrow(
                () -> new RecordNotFoundException(ExceptionMessages.RECORD_NOT_FOUND.getTitle())
        );
        Vote vote = voteRepository.save(
                CreateVoteDTO.to(createVoteDTO,product)
        );
        return new SuccessfulResponseDTO(vote.getId(), ApplicationMessages.OPERATION_COMPLETED.getTitle());
    }

    @Override
    public List<VoteDTO> findAllByProductId(UUID productId) {
        List<Vote> votes = voteRepository.findAllByProductId(productId);
        return VoteDTO.from(votes);
    }

    @Override
    public SuccessfulResponseDTO submitOrRejectVote(UUID voteId) {
        Vote vote = voteRepository.findById(voteId).orElseThrow(
                () -> new RecordNotFoundException(ExceptionMessages.RECORD_NOT_FOUND.getTitle())
        );
        voteRepository.save(
                vote.changeSubmitted()
        );
        return new SuccessfulResponseDTO(ApplicationMessages.OPERATION_COMPLETED.getTitle());
    }
}
