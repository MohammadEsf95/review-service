package com.api.reviewservice.domain;

public enum SubmitStatus {
    SUBMITTED(0,"submitted"),
    REJECTED(1,"rejected"),
    NOT_SPECIFIED(2,"not_specified")
    ;
    private final int index;
    private final String status;

    SubmitStatus(int index, String status) {
        this.index = index;
        this.status = status;
    }

    public static SubmitStatus getFromString(String submitStatusString) {
        for (SubmitStatus submitStatus : SubmitStatus.values()) {
            if (submitStatus.getStatus().equals(submitStatusString))
                return submitStatus;
        }
        return SubmitStatus.NOT_SPECIFIED;
    }

    public int getIndex() {
        return index;
    }

    public String getStatus() {
        return status;
    }

    @Override
    public String toString() {
        return "SubmitStatus{" +
                "index=" + index +
                ", status='" + status + '\'' +
                '}';
    }
}
