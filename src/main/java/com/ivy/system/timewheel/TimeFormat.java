package com.ivy.system.timewheel;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TimeFormat {

    private static ThreadLocal<DateFormat> local = new ThreadLocal<DateFormat>(){
        @Override
        protected DateFormat initialValue() {
            return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        }
    };

    public static String getNowTime(){
        return local.get().format(new Date());
    }
}
