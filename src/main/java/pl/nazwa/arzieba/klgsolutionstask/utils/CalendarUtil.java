package pl.nazwa.arzieba.klgsolutionstask.utils;

import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.temporal.ChronoUnit;
import java.util.Calendar;
import java.util.Date;

@Component
public class CalendarUtil {

    public static String cal2string(Calendar calendar) {
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH);
        int realMonth = month+1;
        String stringMonth = realMonth<10? "0"+realMonth:""+realMonth;
        int day = calendar.get(Calendar.DAY_OF_MONTH);
        String stringDay = day<10? "0"+day:""+day;
        return year+"-"+stringMonth+"-"+stringDay;
    }

    public static Calendar string2cal(String dateToParse) {
        String stringDate = dateToParse;
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        Date date;

        try {
            date = formatter.parse(stringDate);
            Calendar calender = Calendar.getInstance();
            calender.setTime(date);
            return calender;
        } catch (ParseException e) {
            e.getMessage();
        }
        return null;
    }

    public static String invertDateString(String date){
        String[] strings = date.split("-");
        String result = strings[2]+"-"+strings[1]+"-"+strings[0];
        return result;
    }

    public static String invertDateCal(Calendar calendar){
        String stringDate = cal2string(calendar);
        return invertDateString(stringDate);
    }

    public static long betweenDays(String start, String end){
        Calendar startDay = string2cal(start);
        Calendar endDay = string2cal(end);

        return ChronoUnit.DAYS.between(startDay.toInstant(),endDay.toInstant());
    }
}
