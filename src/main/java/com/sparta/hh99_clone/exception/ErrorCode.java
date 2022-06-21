package com.sparta.hh99_clone.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter // ErrorResponse 에서 빌드하기 위해 getter 로 가져오기
public enum ErrorCode {
    // --- 400 Bad Request ---

    // --- 401 Unauthorized ---
    UNAUTHORIZED(HttpStatus.UNAUTHORIZED, "401", "Invalid token"),

    // --- 403 Forbidden ---
    NOT_USER_CART(HttpStatus.FORBIDDEN, "403", "Forbidden"),

    // --- 404 Not Found ---
    NOT_FOUND_VEHICLE(HttpStatus.NOT_FOUND, "404_1", "Not existing vehicle"),
    NOT_FOUND_ITEM(HttpStatus.NOT_FOUND, "404_2", "Not existing item"),
    NOT_FOUND_CART(HttpStatus.NOT_FOUND, "404_3", "Not existing cart"),
    NOT_FOUND_QUANTITY(HttpStatus.NOT_FOUND, "404_4", "Please add item to cart"),
    NOT_FOUND_CARTITEM(HttpStatus.NOT_FOUND, "404_5", "There are no items in the cart"),

    // --- 409 Conflict ---
    USER_EMAIL_CONFLICT(HttpStatus.CONFLICT, "409", "This email address already exists on the server"),

    ;

    private final HttpStatus httpStatus;
    private final String errorCode;         // 메세지로 해도 되지만 만약 국가적 서비스로 나갈 경우, ErrorCode 도 찍어주는게 일반적
    private final String errorMessage;      // 자유

    ErrorCode(HttpStatus httpStatus, String errorCode, String errorMessage) {
        this.httpStatus = httpStatus;
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
    }
}