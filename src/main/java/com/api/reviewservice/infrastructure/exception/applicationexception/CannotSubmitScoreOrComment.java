package com.api.reviewservice.infrastructure.exception.applicationexception;

public class CannotSubmitScoreOrComment extends BaseApplicationException {
    public CannotSubmitScoreOrComment(String message) {
        super(message);
    }
}
