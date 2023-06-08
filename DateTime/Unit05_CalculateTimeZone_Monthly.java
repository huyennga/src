package DateTime;


import java.time.LocalDate;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

// verify time ở UI: next date là base on timezone của user nhưng show trên UI là time của hệ thống máy.
public class Unit05_CalculateTimeZone_Monthly {
    public static void main(String[] args) {
        String currentUserDate = "";
        ZoneId zoneId = ZoneId.of("Asia/Jakarta");
        ZonedDateTime today = ZonedDateTime.now(ZoneId.of("Asia/Jakarta")); // 2023-05-28T17:53:42.165980200+07:00[Asia/Jakarta]
        ZonedDateTime todayUTC = ZonedDateTime.now(ZoneId.of("UTC")); // 2023-05-28T10:53:51.046714200Z[UTC]
        int currentDayOfMonth = today.getDayOfMonth(); // 28
        LocalDate todayToGetMonth = LocalDate.now(zoneId); // 2023-05-28
        int totalDayOfMonth = todayToGetMonth.lengthOfMonth();  // 31
        String timezone = today.getOffset().getId().substring(0, 3); // +07
        String hour;
        if (timezone.contains("+")) {
            hour = String.valueOf(24 - Integer.parseInt(timezone.substring(1, 3))); // 24 - 7 = 17
        } else {
            hour = timezone.substring(1, 3);
        }

        LocalDate localDate = todayUTC.toLocalDate(); // 2023-05-28
        ZonedDateTime nextDate = ZonedDateTime.parse(localDate + "T" + hour + ":00Z"); // 2023-05-28T17:00Z
        int diffDay;
        int dayOfMonthFromSchedule = 25;
        if (todayUTC.isAfter(nextDate)) {
            if (dayOfMonthFromSchedule == currentDayOfMonth) {
                todayUTC = todayUTC.plusMonths(1L);
            } else if (dayOfMonthFromSchedule < currentDayOfMonth) {
                diffDay = currentDayOfMonth - dayOfMonthFromSchedule;
                todayUTC = todayUTC.plusDays((long)(-diffDay));
                todayUTC = todayUTC.plusMonths(1L);
            } else if (totalDayOfMonth < dayOfMonthFromSchedule) {
                todayUTC = todayUTC.withDayOfMonth(totalDayOfMonth);
            } else {
                diffDay = dayOfMonthFromSchedule - currentDayOfMonth;
                todayUTC = todayUTC.plusDays((long)diffDay);
            }
        } else if (dayOfMonthFromSchedule == currentDayOfMonth) {
            todayUTC = todayUTC.plusMonths(1L).minusDays(1L);
        } else if (dayOfMonthFromSchedule < currentDayOfMonth) {
            diffDay = currentDayOfMonth - dayOfMonthFromSchedule;
            todayUTC = todayUTC.plusDays((long)(-diffDay)).minusDays(1L);
            todayUTC = todayUTC.plusMonths(1L);
        } else if (totalDayOfMonth < dayOfMonthFromSchedule) {
            todayUTC = todayUTC.withDayOfMonth(totalDayOfMonth).minusDays(1L);
        } else {
            diffDay = dayOfMonthFromSchedule - currentDayOfMonth;
            todayUTC = todayUTC.plusDays((long)diffDay).minusDays(1L);
        }

        localDate = todayUTC.toLocalDate();
        nextDate = ZonedDateTime.parse(localDate + "T" + hour + ":00Z").withZoneSameInstant(ZoneId.systemDefault());
        DateTimeFormatter df = DateTimeFormatter.ofPattern("MMM d, yyyy, h:mm a O.", Locale.ENGLISH);
        currentUserDate = nextDate.format(df);


    }


}
