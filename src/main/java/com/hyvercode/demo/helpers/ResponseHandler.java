package com.hyvercode.demo.helpers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class ResponseHandler {

    public static ResponseEntity<Object> baseResponse(HttpStatus httpStatus, Object responseObj, int code, String message) {
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        Map<String, Object> map = new HashMap<>();
        map.put("content", responseObj);
        map.put("status", code);
        map.put("message", message);
        map.put("time_stamp",df.format(new Date()));
        map.put("time_ISO_8601",new Date());

        return new ResponseEntity<>(map,httpStatus);
    }
}
