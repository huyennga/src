package DateTime;

import java.time.LocalDate;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Locale;

public class Time {
    public static void main(String[] args) {



        LocalDate today = LocalDate.now();
        System.out.println(today);


        DateTimeFormatter df = DateTimeFormatter.ofPattern("MMM d, yyyy", Locale.ENGLISH);
        System.out.println(today.format(df)); //May 29, 2023, 12:00 AM GMT+7.

    }
}
