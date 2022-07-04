package com.hyvercode.demo.helpers;

import lombok.AllArgsConstructor;
@AllArgsConstructor
public enum ResponseCode {
    HTTP_CODE_200 (200,"OK");

    private int code;
    private String message;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
