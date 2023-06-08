package DateTime;


import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;

public class Unit02_DateFormatter {
    public static void main(String[] args) {
        // get the current date/time in Java -- No timezone: ==> 2023-05-27T17:00:42.143613600
        LocalDateTime today2 = LocalDateTime.now();
        System.out.println("today is " + today2);  // ==> 2023-05-27T17:00:42.143613600

        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        Date date = new Date();
        System.out.println(dateFormat.format(date)); // result: 2023/05/27 17:08:55


        DateFormat dateFormat2 = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        LocalDateTime today3 = LocalDateTime.now();
       // can't use dataFormat for this case , should be trim it to the same format
        String timeBeforeTrim = today3.toString();
        String timeAfterTrim = timeBeforeTrim.substring(0, timeBeforeTrim.indexOf("18"));
        System.out.println(" time after trim and format" + timeAfterTrim);

        
    }
}
