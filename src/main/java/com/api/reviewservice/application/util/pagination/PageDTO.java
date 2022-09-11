package com.api.reviewservice.application.util.pagination;

import java.io.Serializable;
import java.util.List;

public class PageDTO<T> implements Serializable {

    private final List<T> items;
    private long totalCount;

    public PageDTO(List<T> items) {
        this.items = items;
    }

    public PageDTO(List<T> items, long totalCount) {
        this.items = items;
        this.totalCount = totalCount;
    }

    public List<T> getItems() {
        return items;
    }

    public long getTotalCount() {
        return totalCount;
    }

    @Override
    public String toString() {
        return "PageDTO{" +
                "items=" + items +
                ", totalCount=" + totalCount +
                '}';
    }
}
