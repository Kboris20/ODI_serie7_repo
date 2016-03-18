package servlets;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author boris.klett
 */
public class LongToDate {

    private static Date date;

    public static Date getSessionDate() {
        return date;
    }

    public static void setSessionDate(Long p_date) {
        LongToDate.date = new Date(p_date);
    }

    public static String toStringg() {
        DateFormat df = new SimpleDateFormat("dd/MM/yyyy à HH:mm:ss");
        return df.format(date);
    }

}
