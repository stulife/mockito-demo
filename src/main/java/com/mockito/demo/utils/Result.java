package com.mockito.demo.utils;

import lombok.Data;

import java.io.Serializable;

@Data
public class Result implements Serializable {

    private static final int SUCCESS = 200;
    private static final int FAILURE = -1;

    private Boolean success;

    private Integer errorCode;

    private String message;

    private Object data;

    private Result(Boolean success, Integer errorCode, String message, Object data) {
        this.success = success;
        this.errorCode = errorCode;
        this.message = message;
        this.data = data;
    }

    public static Result success() {
        return new Result(true, SUCCESS, null, null);
    }

    public static Result success(Object data) {
        return success(null, data);
    }

    public static Result success(String message, Object data) {
        return new Result(true, SUCCESS, message, data);
    }

    public static Result fail(Integer code, String message) {
        return new Result(false, code, message, null);
    }

    public static Result fail(String message) {
        return new Result(false, FAILURE, message, null);
    }

}