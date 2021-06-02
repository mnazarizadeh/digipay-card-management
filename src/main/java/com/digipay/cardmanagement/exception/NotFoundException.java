package com.digipay.cardmanagement.exception;

import com.digipay.cardmanagement.constant.ExceptionMessage;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND)
public class NotFoundException extends DigipayRuntimeException {

    public NotFoundException() {
        this(ExceptionMessage.NOT_FOUND);
    }

    public NotFoundException(String message) {
        super(message);
    }
}
