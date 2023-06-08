package JavaCollection;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;

public class bbbbb {


    public static void main(String[] args) throws ParseException {

        String startTimeFromUi = "Saturday, Apr 23, 2018 14:31:06 PM"
                // .replace(" ", "")
                .replace("pm", "PM")
                .replace("am", "AM");

        System.out.println(startTimeFromUi);

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("EEEE, MMM dd, yyyy HH:mm:ss a");
// DateTimeFormatter formatter = DateTimeFormatter.ISO_INSTANT;


        LocalDateTime startTimeFromUiConverted = LocalDateTime.parse(startTimeFromUi, formatter);
        // .atZone(ZoneId.systemDefault()).withZoneSameInstant(ZoneId.of("UTC")).toString()
        System.out.println("startTimeFromUiConverted " + startTimeFromUiConverted);

        // LocalDateTime parse = new LocalDateTime("E, MMM dd, yyyy hh:mm a").parse(startTimeFromUi);
    }
    }

