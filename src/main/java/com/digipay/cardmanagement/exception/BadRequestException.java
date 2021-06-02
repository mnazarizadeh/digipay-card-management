package com.digipay.cardmanagement.exception;

import com.digipay.cardmanagement.constant.ExceptionMessage;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.BAD_REQUEST)
public class BadRequestException extends DigipayRuntimeException {

    public BadRequestException() {
        this(ExceptionMessage.TRANSACTION_NOT_FOUND);
    }

    public BadRequestException(String message) {
        super(message);
    }
}
