package com.api.reviewservice.infrastructure.exception;

public enum ExceptionMessages {
    RECORD_NOT_FOUND(8, "Record not found."),
    ;

    private final int index;
    private final String title;

    ExceptionMessages(int index, String title) {
        this.index = index;
        this.title = title;
    }

    public int getIndex() {
        return index;
    }

    public String getTitle() {
        return title;
    }

    @Override
    public String toString() {
        return "ExceptionMessages{" +
                "index=" + index +
                ", title='" + title + '\'' +
                '}';
    }
}
