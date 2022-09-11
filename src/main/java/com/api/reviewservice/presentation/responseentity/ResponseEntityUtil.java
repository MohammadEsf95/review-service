package com.api.reviewservice.presentation.responseentity;

import com.api.reviewservice.presentation.responseentity.response.ServiceUnavailableResponseEntity;
import com.api.reviewservice.presentation.responseentity.response.SuccessfulRequestResponseEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class ResponseEntityUtil {
    public static ResponseEntity<Object> generateSuccessfulRequestResponseEntity(
            SuccessfulRequestResponseEntity<?> successfulRequestResponseEntity
    ) {
        return ResponseEntity.status(HttpStatus.OK).body(successfulRequestResponseEntity);
    }

    public static ResponseEntity<Object> generateAcceptedRequestResponseEntity(
            ServiceUnavailableResponseEntity<?> serviceUnavailableResponseEntity
    ) {
        return ResponseEntity.status(HttpStatus.SERVICE_UNAVAILABLE).body(serviceUnavailableResponseEntity);
    }
}
