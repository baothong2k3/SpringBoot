/*
 * @ (#) GlobalExceptionHandler.java    1.0    22/11/2024
 * Copyright (c) 2024 IUH. All rights reserved.
 */
package org.example.dangbaothong_21014091_springapi.exceptions;/*
 * @description:
 * @author: Bao Thong
 * @date: 22/11/2024
 * @version: 1.0
 */

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.LinkedHashMap;
import java.util.Map;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(ItemNotFoundException.class)
    public ResponseEntity<Map<String, Object>> userNotFoundException(ItemNotFoundException ex) {
        Map<String, Object> errors = new LinkedHashMap<String, Object>();
        errors.put("status", HttpStatus.NOT_FOUND.value());
        errors.put("message", ex.getMessage());
        return new ResponseEntity<Map<String, Object>>(errors, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<Map<String, Object>> globleExcpetionHandler(Exception ex) {
        Map<String, Object> errors = new LinkedHashMap<String, Object>();
        errors.put("status", HttpStatus.INTERNAL_SERVER_ERROR.value());
        errors.put("message", ex.getMessage());
        return new ResponseEntity<Map<String, Object>>(errors, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
