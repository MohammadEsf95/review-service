package com.api.reviewservice.infrastructure.exception;

public enum ExceptionMessages {
    RECORD_NOT_FOUND(0, "Record not found."),
    CANNOT_SUBMIT_SCORE_OR_COMMENT(1, "Cannot submit score or comment."),
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
