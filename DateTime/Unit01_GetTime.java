package DateTime;


import java.time.*;
import java.util.Calendar;
import java.util.Date;

public class Unit01_GetTime {
    public static void main(String[] args) {
        // get the current date/time in Java -- Have time zone ==> today is 2023-05-27T17:00:42.136089800+07:00[Asia/Jakarta]
        ZonedDateTime today = ZonedDateTime.now(ZoneId.of("Asia/Jakarta"));
        System.out.println("today is " + today); // 2023-05-27T17:00:42.136089800+07:00[Asia/Jakarta]

        // get the current date/time in Java -- No timezone: ==> 2023-05-27T17:00:42.143613600
        LocalDateTime today2 = LocalDateTime.now();
        System.out.println("ldt is " + today2);

        // get the current date/time in Java -- ==> Sat May 27 17:03:33 ICT 2023
        Date a = new Date();
        System.out.println( a.getTime());

        Calendar b = Calendar.getInstance();
        System.out.println(b.getTime());  // result: 1685181952260
        System.out.println(b.getFirstDayOfWeek()); // result: 1

        Instant instant = Instant.now();
        System.out.println("instant " + instant );  //  2023-05-27T10:38:33.541440700Z

        ZoneId z = ZoneId.of( "America/Montreal" );
        LocalDate locate = LocalDate.now(z);  // Always pass a time zone.
        System.out.println("locate " + locate); // 2023-05-27
    }


}
