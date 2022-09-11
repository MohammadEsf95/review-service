package com.api.reviewservice.presentation.responseentity.response;

import java.io.Serializable;

public abstract class BaseResponseEntity<T> implements Serializable {

    private final String message;
    private final int code;
    private final T content;

    public BaseResponseEntity(String message, int code, T content) {
        this.message = message;
        this.code = code;
        this.content = content;
    }

    public String getMessage() {
        return message;
    }

    public int getCode() {
        return code;
    }

    public T getContent() {
        return content;
    }

    @Override
    public String toString() {
        return "BaseResponseEntity{" +
                "message='" + message + '\'' +
                ", code=" + code +
                ", content=" + content +
                '}';
    }
}
