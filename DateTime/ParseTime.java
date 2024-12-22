package DateTime;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class ParseTime {


    public static void main(String[] args) throws ParseException {
        Calendar cal = Calendar.getInstance();
        SimpleDateFormat dateFormatUTC = new SimpleDateFormat("MMM d, yyyy");
        String dateText = dateFormatUTC.format(cal.getTime());
        System.out.println("time before parse " + dateText ); //time before parse Nov. 11, 2023
        Date dateAfterFormat = (dateFormatUTC.parse(dateText));
        System.out.println("Date after parse " + dateAfterFormat); //Date after parse Sat Nov 11 00:00:00 ICT 2023

        // ===============================  ===============================
        String startTimeFromUi = "04/05/2023 04:01";
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
        LocalDateTime startTimeFromUiConverted = LocalDateTime.parse(startTimeFromUi, formatter);
        System.out.println("startTimeFromUiConverted " + startTimeFromUiConverted);// startTimeFromUiConverted 2023-05-04T04:01

        // ===============================  ===============================
        String startTimeFromUi2 = "Saturday, Apr 23, 2018 14:31:06 PM"
                // .replace(" ", "")
                .replace("pm", "PM")
                .replace("am", "AM");
        DateTimeFormatter formatter2 = DateTimeFormatter.ofPattern("EEEE, MMM dd, yyyy HH:mm:ss a");
        LocalDateTime startTimeFromUiConverted2 = LocalDateTime.parse(startTimeFromUi2, formatter2);
        System.out.println("startTimeFromUiConverted2 " + startTimeFromUiConverted2); //startTimeFromUiConverted 2023-05-04T04:01

        // ===============================  ===============================
        String outageContent = "From Thu, Apr 20, 2023 1:41 PM to Sun, Apr 23, 2023 1:41 PM (UTC+07:00 Asia/Bangkok)";
        int indexOfTo = outageContent.indexOf(" to");
        int indexOfOpenParentheses = outageContent.indexOf(" (");
        String startTimeFromUi3 = outageContent.substring(5, indexOfTo)
                .replace("pm ", "PM")
                .replace("am ", "AM");

        String endTimeFromUi = outageContent.substring(indexOfTo + 4, indexOfOpenParentheses)
                .replace("pm", "PM")
                .replace("am", "AM");
        DateTimeFormatter formatter3 = new DateTimeFormatterBuilder().parseCaseInsensitive().appendPattern("E,MMM dd,yyyy h:mm a").toFormatter(Locale.ENGLISH);
        LocalDateTime startTimeFromUiConverted3 = LocalDateTime.parse(startTimeFromUi, formatter);
        LocalDateTime endTimeFromUiConverted3 = LocalDateTime.parse(endTimeFromUi, formatter);
        System.out.println("startTimeFromUiConverted3 " + startTimeFromUiConverted3);
        System.out.println("endTimeFromUiConverted3 " + endTimeFromUiConverted3);

    }
}
