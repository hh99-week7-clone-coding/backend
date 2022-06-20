package com.sparta.hh99_clone.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

// 각 컨트롤러 마다 ExceptionHandler 를 적기에는 너무 불필요하다.
// 그러니 모든 Controller 의 예외처리를 도와주는 ControllerAdvice 를 생성
// RestControllerAdvice 는 예외처리를 json 형태로 보내준다.
@RestControllerAdvice
public class RestApiExceptionHandler {

    @ExceptionHandler(value = { IllegalArgumentException.class })
    public ResponseEntity<Object> handleApiRequestException(IllegalArgumentException ex) {
        RestApiException restApiException = new RestApiException();
        restApiException.setHttpStatus(HttpStatus.BAD_REQUEST);
        restApiException.setErrorMessage(ex.getMessage());

        return new ResponseEntity(
                restApiException,
                HttpStatus.BAD_REQUEST
        );
    }
}