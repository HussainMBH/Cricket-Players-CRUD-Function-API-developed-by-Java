package com.dailycodebuffer.cricket.exception;

import lombok.Data;

@Data
public class CricketAppServiceRuntimeException  extends RuntimeException{

    private String errorCode;

    public CricketAppServiceRuntimeException(String message, String errorCode) {
        super(message);
        this.errorCode = errorCode;
    }
}
