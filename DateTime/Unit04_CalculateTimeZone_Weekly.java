package DateTime;


import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

// verify time ở UI: send email theo weekly là based on timezone của user nhưng show trên UI là time của hệ thống máy.
public class Unit04_CalculateTimeZone_Weekly {
    public static void main(String[] args) {


        String currentUserDate = "";
        ZonedDateTime today = ZonedDateTime.now(ZoneId.of("Asia/Jakarta")); // 2023-05-27T18:03:46.516646900+07:00[Asia/Jakarta]
        ZonedDateTime todayUTC = ZonedDateTime.now(ZoneId.of("UTC")); // 2023-05-27T11:03:46.516646900Z[UTC]

        DayOfWeek dayOfWeek = today.getDayOfWeek(); // SUNDAY
        int currentDayOfWeek = dayOfWeek.getValue();  // 7
        String timezone = today.getOffset().getId().substring(0, 3);  // +07
        String hour;
        if (timezone.contains("+")) {
            hour = String.valueOf(24 - Integer.parseInt(timezone.substring(1, 3))); // 24-7= 17
        } else {
            hour = timezone.substring(1, 3);
        }
        LocalDate localDate = todayUTC.toLocalDate();  // 2023-05-27
        ZonedDateTime nextDate = ZonedDateTime.parse(localDate + "T" + hour + ":00Z"); // 2023-05-27T17:00Z
        int diffDay;
        int dayOfWeekFromSchedule = 1;
        if (todayUTC.isAfter(nextDate)) {
            if (dayOfWeekFromSchedule == currentDayOfWeek) {
                todayUTC = todayUTC.plusDays(7L);
            } else if (dayOfWeekFromSchedule < currentDayOfWeek) {
                diffDay = currentDayOfWeek - dayOfWeekFromSchedule;
                todayUTC = todayUTC.plusDays((long)(7 - diffDay));
            } else {
                diffDay = dayOfWeekFromSchedule - currentDayOfWeek;
                todayUTC = todayUTC.plusDays((long)diffDay);
            }
        } else if (dayOfWeekFromSchedule == currentDayOfWeek) {
            todayUTC = todayUTC.plusDays(6L);
        } else if (dayOfWeekFromSchedule < currentDayOfWeek) {
            diffDay = currentDayOfWeek - dayOfWeekFromSchedule;
            todayUTC = todayUTC.plusDays((long)(6 - diffDay));
        } else {
            diffDay = dayOfWeekFromSchedule - currentDayOfWeek;
            todayUTC = todayUTC.plusDays((long)(diffDay - 1));
        }
        // next date of next week after calculate
        localDate = todayUTC.toLocalDate();
        nextDate = ZonedDateTime.parse(localDate + "T" + hour + ":00Z").withZoneSameInstant(ZoneId.systemDefault());
        DateTimeFormatter df = DateTimeFormatter.ofPattern("MMM d, yyyy, h:mm a O.", Locale.ENGLISH);
        currentUserDate = nextDate.format(df);


    }


}
