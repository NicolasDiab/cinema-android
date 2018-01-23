package fr.polytech.com.cinema.utils;

import java.util.Calendar;
import java.util.Date;

/**
 * Created by nico- on 23/01/2018.
 */

public class Utils {
    public static int getYearFromDate(Date date) {
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        return c.get(Calendar.YEAR);
    }
}
