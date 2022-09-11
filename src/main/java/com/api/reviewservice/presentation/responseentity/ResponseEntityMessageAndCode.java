package com.api.reviewservice.presentation.responseentity;

public enum ResponseEntityMessageAndCode {
    OK(200, "Operation completed successfully."),
    SERVICE_UNAVAILABLE(503, "Operation failed to be completed.");

    private final int code;
    private final String title;

    ResponseEntityMessageAndCode(int code, String title) {
        this.code = code;
        this.title = title;
    }

    public int getCode() {
        return code;
    }

    public String getTitle() {
        return title;
    }
}
