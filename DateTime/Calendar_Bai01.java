package DateTime;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

public class Calendar_Bai01 {


    public static void main(String[] args) throws ParseException {

        Calendar  calendar = Calendar.getInstance();

        // Program to demonstrate get() method
        System.out.println("Current Calendar's Year: " + calendar.get(Calendar.YEAR)); //Current Calendar's Year: 2023
        System.out.println("Current Calendar's Day: " + calendar.get(Calendar.DATE)); //Current Calendar's Day: 9
        System.out.println("Current MINUTE: " + calendar.get(Calendar.MINUTE)); //Current MINUTE: 55
        System.out.println("Current SECOND: " + calendar.get(Calendar.SECOND)); //Current SECOND: 25
        // Getting the time zone of calendar
        TimeZone time_zone = calendar.getTimeZone();
        // Displaying the current time zone
        System.out.println("The current Time zone is: "   + time_zone.getDisplayName()); // The current Time zone is: Asia/Bangkok

        // =============================== ===============================
        // Program to demonstrate getMaximum() method
        int max = calendar.getMaximum(Calendar.DAY_OF_WEEK); //Maximum number of days in a week: 7
        System.out.println("Maximum number of days in a week: " + max); //Maximum number of weeks in a year: 53

        max = calendar.getMaximum(Calendar.WEEK_OF_YEAR);
        System.out.println("Maximum number of weeks in a year: " + max); //Minimum number of days in week: 1

        // =============================== ===============================
        // Program to demonstrate getMinimum() method
        int min = calendar.getMinimum(Calendar.DAY_OF_WEEK);
        System.out.println("Minimum number of days in week: " + min);//Minimum number of weeks in year: 1

        min = calendar.getMinimum(Calendar.WEEK_OF_YEAR);
        System.out.println("Minimum number of weeks in year: " + min);

        // =============================== ===============================
        // Program to demonstrate add() method
        calendar.add(Calendar.DATE, -15);
        System.out.println("15 days ago: " + calendar.getTime()); //15 days ago: Wed Oct 25 15:55:25 ICT 2023
        calendar.add(Calendar.MONTH, 4);
        System.out.println("4 months later: " + calendar.getTime()); //4 months later: Sun Feb 25 15:55:25 ICT 2024
        calendar.add(Calendar.YEAR, 2);
        System.out.println("2 years later: " + calendar.getTime());//2 years later: Wed Feb 25 15:55:25 ICT 2026

        // =============================== ===============================
        // setTimeInMillis() method
        System.out.println("The Current"  + " Time is: "   + calendar.getTime());  //The Current Time is: Wed Feb 25 15:55:25 ICT 2026
            // Changing time to 2000 milli-second
            calendar.setTimeInMillis(8000);
            // Displaying the new time
            System.out.println("After setting"  + " Time: "  + calendar.getTime()); //After setting Time: Thu Jan 01 07:00:08 ICT 1970


        // =============================== ===============================
        // Clear method for undefining the month  =?is used to set a given calendar field value and the time value of this Calendar undefined.
        // of the calendar
        calendar.clear(Calendar.MONTH);
        System.out.println("After clear method: "  + calendar.getTime());// After clear method: Thu Jan 01 07:00:08 ICT 1970

    }
}
