package com.digipay.cardmanagement.util;

import java.time.LocalDate;
import java.util.Calendar;

public class CardUtil {

    public static Boolean validateExpireDate (String expireDate) {
        DateConverter dateConverter = new DateConverter();
        String[] now = dateConverter.getDateShamsiText(LocalDate.now()).split("/");
        String[] date = expireDate.split("-");
        return Integer.parseInt(date[0]) >= Integer.parseInt(now[0])%100 && Integer.parseInt(date[1]) >= Integer.parseInt(now[1]);
    }

    public static String getBin(String pan) {
        if (pan == null)
            return null;

        return pan.substring(0,6);
    }
}
