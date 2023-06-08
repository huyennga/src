package DateTime;


import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

// verify time ở UI: next date là base on timezone của user nhưng show trên UI là time của hệ thống máy.
public class Unit03_CaculateTimeZone {
    public static void main(String[] args) {

        // verify message này ===> May 29, 2023, 12:00 AM GMT+7.  // Asia/Jakarta
        String currentUserDate = "";
        ZonedDateTime today = ZonedDateTime.now(ZoneId.of("Asia/Jakarta")); // 2023-05-27T18:03:46.516646900+07:00[Asia/Jakarta]
        ZonedDateTime todayUTC = ZonedDateTime.now(ZoneId.of("UTC")); // 2023-05-27T11:03:46.516646900Z[UTC]

        // get timezone
        String timezone = today.getOffset().getId().substring(0, 3);  // +07
        String hour;
        if (timezone.contains("+")) {
            hour = String.valueOf(24 - Integer.parseInt(timezone.substring(1, 3))); // => 24 - 7 = 17
        } else {
            hour = timezone.substring(1, 3);
        }

        LocalDate localDate = today.toLocalDate(); // 2023-05-28
        ZonedDateTime nextDate = ZonedDateTime.parse(localDate + "T" + hour + ":00Z"); //==>  2023-05-28T17:00Z
        if (todayUTC.isAfter(nextDate)) {
            nextDate = nextDate.plusDays(1L);
        }
        nextDate = nextDate.withZoneSameInstant(ZoneId.systemDefault());  // 2023-05-29T00:00+07:00[Asia/Bangkok]
        DateTimeFormatter df = DateTimeFormatter.ofPattern("MMM d, yyyy, h:mm a O.", Locale.ENGLISH);
        currentUserDate = nextDate.format(df); //May 29, 2023, 12:00 AM GMT+7.

    }
}
