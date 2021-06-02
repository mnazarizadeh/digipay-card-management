package com.digipay.cardmanagement.util;

import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class DateConverter {
    static int[] shamsiMonth = {31, 31, 31, 31, 31, 31, 30, 30, 30, 30, 30, 29};
    static int[] miladiMonth = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
    static int differenceDays = 226899;
    static int differenceKabisehDays = 155;

    public int kabisehChecker(int year) {
        if ((year % 4) == 0)
            return 1;
        else
            return 0;
    }

    public String getDateShamsiText (Date date) {
        Calendar calendar = new GregorianCalendar();
        calendar.setTime(date);
        int[] out = miladi2Shamsi(
                calendar.get(Calendar.YEAR),
                calendar.get(Calendar.MONTH) + 1,
                calendar.get(Calendar.DAY_OF_MONTH));
        return out[0] + "/" + out[1] + "/" + out[2];
    }

    public String getDateShamsiText (LocalDate date) {
        int[] out = miladi2Shamsi(date.getYear(), date.getMonthValue(), date.getDayOfMonth());
        return out[0] + "/" + out[1] + "/" + out[2];
    }

    public String getDateTimeShamsiText(Instant date) {
        Date myDate = Date.from(date);
        return getDateTimeShamsiText(myDate);
    }

    public String getDateTimeShamsiText (Date date) {
        SimpleDateFormat formatter = new SimpleDateFormat("HH:mm:ss");
        String formattedTime = formatter.format(date);
        return getDateShamsiText(date) + " " + formattedTime ;
    }

    public String getDateShamsiText (String date) {
        int[] out;
        String[] d = date.split("/");
        if (d.length < 3)
            return date + "pure";
        out = miladi2Shamsi(Integer.parseInt(d[0]), Integer.parseInt(d[1]), Integer.parseInt(d[2]));
        return out[0] + "/" + out[1] + "/" + out[2];
    }

    public String getDateMiladiText (String date) {
        int[] out;
        String[] d = date.split("/");
        if (d.length < 3)
            return date + "pure";
        out = shamsi2Miladi(d[0], d[1], d[2]);
        return out[0] + "/" + out[1] + "/" + out[2];
    }

    public String nextDayMiladi(String today) {
        String s[] = today.split("/");

        int yy = Integer.parseInt(s[0]);
        int mm = Integer.parseInt(s[1]);
        int dd = Integer.parseInt(s[2]);

        if (kabisehChecker(yy) == 1) {
            shamsiMonth[11] = 30;
        } else {
            shamsiMonth[11] = 29;
        }

        dd++;

        if (dd > miladiMonth[mm - 1]) {
            dd = 1;
            mm++;
        }
        if (mm > 12) {
            mm = 1;
            yy++;
        }

        String y = yy + "";
        String m = mm > 9 ? "" + mm : "0" + mm;
        String d = dd > 9 ? "" + dd : "0" + dd;

        return y + "/" + m + "/" + d;
    }

    public String prevDayMiladi(String today) {

        String s[] = today.split("/");

        int yy = Integer.parseInt(s[0]);
        int mm = Integer.parseInt(s[1]);
        int dd = Integer.parseInt(s[2]);

        if (kabisehChecker(yy) == 1) {
            shamsiMonth[11] = 30;
        } else {
            shamsiMonth[11] = 29;
        }

        dd--;

        if (dd <= 0) {
            mm--;
            dd = miladiMonth[mm - 1];
        }
        if (mm <= 0) {
            mm = 12;
            yy--;
        }

        String y = yy + "";
        String m = mm > 9 ? "" + mm : "0" + mm;
        String d = dd > 9 ? "" + dd : "0" + dd;

        return y + "/" + m + "/" + d;
    }

    public int[] shamsi2Miladi(String y, String m, String d) {
        int[] result = new int[3];

        int year = Integer.parseInt(y);
        int month = Integer.parseInt(m);
        int day = Integer.parseInt(d);

        Roozh jCal = new Roozh(); // Make an instance
        jCal.PersianToGregorian(year, month, day); // Convert the date
        result[0] = jCal.getYear();
        result[1]=jCal.getMonth();
        result[2]=jCal.getDay();

        return result;
    }

    public int[] miladi2Shamsi(String y, String m, String d) {

        int[] result = new int[3];

        int year = Integer.parseInt(y);
        int month = Integer.parseInt(m);
        int day = Integer.parseInt(d);

        Roozh jCal = new Roozh(); // Make an instance
        jCal.GregorianToPersian(year, month, day); // Convert the date
        result[0] = jCal.getYear();
        result[1]=jCal.getMonth();
        result[2]=jCal.getDay();

        return result;

    }

    public int[] miladi2Shamsi(int year, int month, int day) {

        int[] result = new int[3];

        Roozh jCal = new Roozh(); // Make an instance
        jCal.GregorianToPersian(year, month, day); // Convert the date
        result[0] = jCal.getYear();
        result[1]=jCal.getMonth();
        result[2]=jCal.getDay();

        return result;

    }
}