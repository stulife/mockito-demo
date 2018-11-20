package com.mockito.demo.utils;

import java.util.Calendar;
import java.util.Date;

public class DateUtils {

    /**
     * 获取某个日期所在月份
     *
     * @param date
     * @return
     */
    public static int getMonth(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return calendar.get(Calendar.MONTH);
    }
}
