package JavaCollection;

import java.text.ParseException;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.util.Locale;

public class cccc {


    public static void main(String[] args) throws ParseException {
        String outageContent = "From Thu, Apr 20, 2023 1:41 PM to Sun, Apr 23, 2023 1:41 PM (UTC+07:00 Asia/Bangkok)";
        int indexOfTo = outageContent.indexOf(" to");
        int indexOfOpenParentheses = outageContent.indexOf(" (");

        String startTimeFromUi = outageContent.substring(5, indexOfTo)
                .replace("pm ", "PM")
                .replace("am ", "AM");


        String endTimeFromUi = outageContent.substring(indexOfTo + 4, indexOfOpenParentheses)
                .replace("pm", "PM")
                .replace("am", "AM");


        System.out.println(startTimeFromUi);
        System.out.println(endTimeFromUi);

        // DateTimeFormatter formatter = DateTimeFormatter.ofPattern("E, MMM dd, yyyy h:mm a");
        DateTimeFormatter formatter = new DateTimeFormatterBuilder().parseCaseInsensitive().appendPattern("E,MMM dd,yyyy h:mm a").toFormatter(Locale.ENGLISH);
// DateTimeFormatter formatter = DateTimeFormatter.ISO_INSTANT;

        System.out.println(Locale.getDefault());


        LocalDateTime startTimeFromUiConverted = LocalDateTime.parse(startTimeFromUi, formatter);
        LocalDateTime endTimeFromUiConverted = LocalDateTime.parse(endTimeFromUi, formatter);
        // .atZone(ZoneId.systemDefault()).withZoneSameInstant(ZoneId.of("UTC")).toString()
        System.out.println("startTimeFromUiConverted " + startTimeFromUiConverted);

        System.out.println("endTimeFromUiConverted " + endTimeFromUiConverted);

        // LocalDateTime parse = new LocalDateTime("E, MMM dd, yyyy hh:mm a").parse(startTimeFromUi);
    }
    }

