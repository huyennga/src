package DateTime;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class DateFormat_Bai01 {


    public static void main(String[] args) throws ParseException {

        SimpleDateFormat dateFormatUTC = new SimpleDateFormat("MMM d, yyyy");
        Date date_a = new Date();
        String dateAfterFormat = dateFormatUTC.format(date_a.getTime());
        System.out.println("Date after format " + dateAfterFormat); //Date after format Nov. 11, 2023

        // =============================== DateFormat.getDateTimeInstance ===============================
        // Initializing DateFormat
        DateFormat DFormat =  DateFormat.getDateTimeInstance();
        // Displaying the formats
        Date date = new Date();
        String str_Date1 = DFormat.format(date);
        System.out.println("The Original: "  + (str_Date1)); //The Original: Nov. 11, 2023, 4:04:30 p.m.
        // Displaying the hash code
        System.out.println("The hash code: " + DFormat.hashCode());//The hash code: -111348863

        // =============================== SimpleDateFormat ===============================
        SimpleDateFormat  DFormat2 = new SimpleDateFormat("MM/dd/yyyy");
        Date date2 = new Date();
        String str_Date2 = DFormat2.format(date2);
        System.out.println("The Original: " + (str_Date2));  //The Original: 11/11/2023
        // Displaying the hash code
        System.out.println("The hash code: "  + DFormat2.hashCode()); //The hash code: 2087096576

        // ===============================  DateFormat.getDateInstance( ===============================
        // Initializing SimpleDateFormat by    // creating object of SimpleDateFormat class
        SimpleDateFormat SDFormat  = new SimpleDateFormat("MM/dd/yyyy");
        // Printing the formats
        Date date3 = new Date();
        String str_Date3 = SDFormat.format(date3);
        // Displaying  the original date
        System.out.println("The Original: " + (str_Date3)); //The Original: 11/11/2023
        // Initializing the Date formatter
        DateFormat DFormat3 = DateFormat.getDateInstance();
        System.out.println("Object: " + DFormat3); //Object: java.text.SimpleDateFormat@ad508834
        // Formatting the string
        String str = DFormat3.format(new Date());
        // Printing the string date on console
        System.out.println("Date after formnat " + str); //Nov. 11, 2023

        // =============================== DATE LOCATE  ===============================
        // Get the available locales
        Locale loc_list[]  = DateFormat.getAvailableLocales();
        // Print the locales
        // along with display names
        System.out.println("Available Locales" + " :: Display names\n");
        for (int count = 0; count < 3; count++) {
            System.out.println(loc_list[count].toString() + " :: "   + loc_list[count].getDisplayName()); //th_TH_#Thai :: Thai (Thai, Thailand)
        }
        for (int count = 0;   count < 3; count++) {
            System.out.println( loc_list[count].getDisplayName(Locale.ENGLISH)); //Thai (Thai, Thailand)
        }

        // =============================== DATE TIME ZONE  ===============================
        // Initializing the first formatter
        DateFormat DFormat4   = DateFormat.getDateInstance();
        // Converting the dateformat to string
        String str4 = DFormat4.format(new Date());
        // Getting the available timezones
        System.out.println(DFormat4.getTimeZone().getDisplayName()); //Indochina Time

        // ===============================  ===============================
        DateTimeFormatter formattera = DateTimeFormatter.ofPattern("E,MMMd,yyyy,h:mma");
        System.out.println("1 " + formattera);
        DateTimeFormatter formatter2 = DateTimeFormatter.ofPattern("E,MMMd,yyyy,hh:mm:ss");
        System.out.println("2 " + formattera);

        Calendar cal = Calendar.getInstance();
        SimpleDateFormat simpleformat = new SimpleDateFormat("E , MMMd, uuuu, h:mma");
        System.out.println("Today's date and time = "+simpleformat.format(cal.getTime()));

        SimpleDateFormat simpleformat2 = new SimpleDateFormat("E,MMMd,yyyy,hh:mm:ss");
        System.out.println("Today's date and time = "+simpleformat2.format(cal.getTime()));


        DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
        String caseStartDate = dateFormat.format(LocalDateTime.now());
        String currentTime = LocalDateTime.now().toString();
        System.out.println("currentTime " + currentTime );
        System.out.println(caseStartDate);
        LocalDateTime localdatetime = LocalDateTime.parse(caseStartDate, dateFormat);
        System.out.println(localdatetime);
    }
}
