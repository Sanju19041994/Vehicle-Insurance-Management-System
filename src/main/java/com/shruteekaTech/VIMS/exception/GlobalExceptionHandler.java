package com.shruteekaTech.VIMS.exception;

import com.shruteekaTech.VIMS.utils.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ApiResponse> handlerResourceNotFoundException(ResourceNotFoundException ex){
        String message = ex.getMessage();
        ApiResponse api = new ApiResponse(message,false);
        return new ResponseEntity<>(api, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String,String>> handlerMethodArgumentNotValidException(MethodArgumentNotValidException ex){
        Map<String,String> map = new HashMap<>();

        ex.getBindingResult().getAllErrors().forEach((error)->{
            String field = ((FieldError) error).getField();
            String defaultMessage = error.getDefaultMessage();

            map.put(field,defaultMessage);
        });
        return new ResponseEntity<>(map,HttpStatus.BAD_REQUEST);
    }

}
