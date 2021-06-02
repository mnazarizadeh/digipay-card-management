package com.digipay.cardmanagement.exception;

import com.digipay.cardmanagement.constant.ExceptionMessage;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.BAD_REQUEST)
public class CardExpiredException extends DigipayRuntimeException {

    public CardExpiredException() {
        this(ExceptionMessage.CARD_EXPIRED);
    }

    public CardExpiredException(String message) {
        super(message);
    }
}
