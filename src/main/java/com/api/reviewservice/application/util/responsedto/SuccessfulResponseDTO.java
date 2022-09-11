package com.api.reviewservice.application.util.responsedto;

import java.util.UUID;

public class SuccessfulResponseDTO {

    private UUID id;
    private String message;

    public SuccessfulResponseDTO(UUID id, String message) {
        this.id = id;
        this.message = message;
    }

    public SuccessfulResponseDTO(String message) {
        this.message = message;
    }

    public UUID getId() {
        return id;
    }

    public String getMessage() {
        return message;
    }
}
