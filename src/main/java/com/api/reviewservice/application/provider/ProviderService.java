package com.api.reviewservice.application.provider;

import com.api.reviewservice.application.provider.dto.CreateProviderDTO;
import com.api.reviewservice.application.util.responsedto.SuccessfulResponseDTO;

public interface ProviderService {

    SuccessfulResponseDTO create(CreateProviderDTO createProviderDTO);
}
