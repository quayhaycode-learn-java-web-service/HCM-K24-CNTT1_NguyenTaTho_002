package com.reptithcm.edu.kiemtrahackathon.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum ErrorCode {
    NOT_FOUND(404, "Not found"),
    DATA_NOT_VALID(400, "Data is not valid" );
    private int code;
    private String message;
}
