package util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Date;

public class DateUtil {
    public static boolean compareDurations(String date, String startDate, String endDate, String format) {
        SimpleDateFormat dateFmt = new SimpleDateFormat(format);
        try {
            Date fromDate = dateFmt.parse(startDate);
            Date toDate = dateFmt.parse(endDate);
            Date actualDate = dateFmt.parse(date);
            if (actualDate.compareTo(fromDate) >= 0 || actualDate.compareTo(toDate) <= 0) {
                return true;
            }
        } catch (ParseException ex) {
            ex.printStackTrace();
        }
        return false;
    }

    public static String getCurrentUTCDate(String dateFormat) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(dateFormat).withZone(ZoneId.of("UTC"));
        String currentUTCDate = formatter.format(Instant.now());
        return currentUTCDate;
    }

    public static String getCurrentUTCSubDays(int days, String dateFormat) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(dateFormat).withZone(ZoneId.of("UTC"));
        Instant instant = Instant.now().minus((long)days, ChronoUnit.DAYS);
        String currentUTCSubDays = formatter.format(instant);
        return currentUTCSubDays;
    }
}
