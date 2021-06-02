package com.digipay.cardmanagement.exception;

import com.digipay.cardmanagement.constant.ExceptionMessage;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.UNAUTHORIZED)
public class UnauthorizedException extends DigipayRuntimeException {

    public UnauthorizedException() {
        this(ExceptionMessage.UNAUTHORIZED);
    }

    public UnauthorizedException(String message) {
        super(message);
    }
}
