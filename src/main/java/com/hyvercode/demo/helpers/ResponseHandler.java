package com.hyvercode.demo.helpers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class ResponseHandler {
    public static ResponseEntity<Object> baseResponse(HttpStatus status, Object responseObj,int code,String message) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("content", responseObj);
        map.put("code", code);
        map.put("message", message);
        map.put("time_stamp",new Date());

        return new ResponseEntity<Object>(map,status);
    }
}
