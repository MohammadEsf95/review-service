package com.api.reviewservice.presentation.provider;

import com.api.reviewservice.application.provider.ProviderService;
import com.api.reviewservice.application.provider.dto.CreateProviderDTO;
import com.api.reviewservice.presentation.responseentity.ResponseEntityUtil;
import com.api.reviewservice.presentation.responseentity.response.SuccessfulRequestResponseEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/provider")
public class ProviderController {

    private final ProviderService providerService;

    public ProviderController(ProviderService providerService) {
        this.providerService = providerService;
    }

    @PostMapping
    public ResponseEntity<Object> create(@RequestBody CreateProviderDTO createProviderDTO) {
        return ResponseEntityUtil.generateSuccessfulRequestResponseEntity(
                new SuccessfulRequestResponseEntity<>(
                        providerService.create(createProviderDTO)
                )
        );
    }
}
