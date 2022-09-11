package com.api.reviewservice.application.provider;

import com.api.reviewservice.application.provider.dto.CreateProviderDTO;
import com.api.reviewservice.application.util.responsedto.SuccessfulResponseDTO;
import com.api.reviewservice.domain.provider.Provider;
import com.api.reviewservice.domain.provider.ProviderRepository;
import com.api.reviewservice.infrastructure.ApplicationMessages;
import org.springframework.stereotype.Service;

@Service
public class ProviderDefaultService implements ProviderService {

    private final ProviderRepository providerRepository;

    public ProviderDefaultService(ProviderRepository providerRepository) {
        this.providerRepository = providerRepository;
    }

    @Override
    public SuccessfulResponseDTO create(CreateProviderDTO createProviderDTO) {
        Provider provider = providerRepository.save(
                CreateProviderDTO.to(createProviderDTO)
        );
        return new SuccessfulResponseDTO(provider.getId(), ApplicationMessages.OPERATION_COMPLETED.getTitle());
    }
}
