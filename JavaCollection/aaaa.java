package JavaCollection;

import java.text.Format;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class aaaa {


    public static void main(String[] args) throws ParseException {

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


        String startTimeFromUi = "04/05/2023 04:01";
                // .replace(" ", "")
                // .replace("pm", "PM")
                // .replace("am", "AM");

        System.out.println(startTimeFromUi);


        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");

// DateTimeFormatter formatter = DateTimeFormatter.ISO_INSTANT;


        LocalDateTime startTimeFromUiConverted = LocalDateTime.parse(startTimeFromUi, formatter);
        // .atZone(ZoneId.systemDefault()).withZoneSameInstant(ZoneId.of("UTC")).toString()
        System.out.println("startTimeFromUiConverted " + startTimeFromUiConverted);

        // LocalDateTime parse = new LocalDateTime("E, MMM dd, yyyy hh:mm a").parse(startTimeFromUi);
    }
}
