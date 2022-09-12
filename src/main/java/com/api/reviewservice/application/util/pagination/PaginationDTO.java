package com.api.reviewservice.application.util.pagination;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.io.Serializable;

public class PaginationDTO implements Serializable {
    public static Pageable pageableByCreateDate(int page, int pageSize) {
        return PageRequest.of(
                page - 1,
                pageSize,
                Sort.by("createDate").descending()
        );
    }

    public static Pageable pageableByUpdateDate(int page, int pageSize) {
        return PageRequest.of(
                page - 1,
                pageSize,
                Sort.by("updateDate").descending()
        );
    }
}
