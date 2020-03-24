package com.sanservices.websitesapi.commons.entity;

import lombok.AccessLevel;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public final class Result<SuccessT, FailureT> {

    private final SuccessT value;
    private final FailureT reason;

    private final boolean isSuccess;

    public static <SuccessT, FailureT> Result<SuccessT, FailureT> success(SuccessT value) {
        return new Result<>(value, null, true);
    }

    public static <SuccessT, FailureT> Result<SuccessT, FailureT> failure(FailureT reason) {
        return new Result<>(null, reason, false);
    }
}
