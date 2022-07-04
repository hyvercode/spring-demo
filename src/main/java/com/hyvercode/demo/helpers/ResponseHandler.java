package com.hyvercode.demo.helpers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class ResponseHandler {

    public ResponseHandler() {
    }

    public static ResponseEntity<Object> baseResponse(HttpStatus httpStatus, Object responseObj, int code, String message) {
        Map<String, Object> map = new HashMap<>();
        map.put("content", responseObj);
        map.put("status", code);
        map.put("message", message);
        map.put("time_stamp",new Date());

        return new ResponseEntity<>(map,httpStatus);
    }
}
