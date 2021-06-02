package com.digipay.cardmanagement.exception;

import com.digipay.cardmanagement.constant.ExceptionMessage;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.BAD_REQUEST)
public class IdExistsException extends DigipayRuntimeException {
    public IdExistsException() {
        this(ExceptionMessage.ID_EXISTS);
    }

    public IdExistsException(String message) {
        super(message);
    }
}
