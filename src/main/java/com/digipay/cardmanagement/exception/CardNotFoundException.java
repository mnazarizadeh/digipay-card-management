package com.digipay.cardmanagement.exception;

import com.digipay.cardmanagement.constant.ExceptionMessage;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND)
public class CardNotFoundException extends DigipayRuntimeException {

    public CardNotFoundException() {
        this(ExceptionMessage.CARD_NOT_FOUND);
    }

    public CardNotFoundException(String message) {
        super(message);
    }
}
