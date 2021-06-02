package com.digipay.cardmanagement.exception;

import com.digipay.cardmanagement.constant.ExceptionMessage;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.BAD_REQUEST)
public class InvalidCardInfoException extends DigipayRuntimeException {

    public InvalidCardInfoException() {
        this(ExceptionMessage.INVALID_CARD);
    }

    public InvalidCardInfoException(String message) {
        super(message);
    }
}