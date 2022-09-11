package com.api.reviewservice.infrastructure.exception.applicationexception;

import com.api.reviewservice.presentation.responseentity.response.BaseResponseEntity;

public class RecordNotFoundException extends BaseApplicationException {
    public RecordNotFoundException(String message) {
        super(message);
    }
}
