package com.api.reviewservice.application.provider.dto;

import com.api.reviewservice.domain.provider.Provider;

import javax.validation.constraints.NotEmpty;

public record CreateProviderDTO(@NotEmpty String name) {
    public CreateProviderDTO(String name) {
        this.name = name;
    }

    public static Provider to(CreateProviderDTO createProviderDTO) {
        return new Provider(createProviderDTO.name());
    }

    @Override
    public String name() {
        return name;
    }
}
