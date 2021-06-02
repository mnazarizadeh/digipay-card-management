package com.digipay.cardmanagement.util;

import java.time.LocalDate;
import java.util.Calendar;

public class DateUtil {

    public static LocalDate convertExpireDate (String expireDate) {
        String[] date = expireDate.split("-");
        return LocalDate.now();
    }
}
