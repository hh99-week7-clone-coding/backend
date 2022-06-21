package com.sparta.hh99_clone.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

// 각 컨트롤러 마다 ExceptionHandler 를 적기에는 너무 불필요하다.
// 그러니 모든 Controller 의 예외처리를 도와주는 ControllerAdvice 를 생성
// RestControllerAdvice 는 예외처리를 json 형태로 보내준다.
@RestControllerAdvice
public class RestApiExceptionHandler {

    // .class 의 throw 값을 잡겠다는 뜻
    @ExceptionHandler(value = { CustomException.class })
    public ResponseEntity<ErrorResponse> handleApiRequestException(CustomException ex) {
        return ErrorResponse.responseEntity(ex.getErrorCode());
    }
}