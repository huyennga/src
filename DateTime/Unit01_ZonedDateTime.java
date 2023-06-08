package DateTime;

import java.time.*;
import java.time.temporal.TemporalAdjusters;

import static java.time.temporal.TemporalAdjusters.*;

public class Unit01_ZonedDateTime {
    public static void main(String[] args) {
        ZoneId losAngeles = ZoneId.of("America/Los_Angeles");
        ZoneId berlin = ZoneId.of("Europe/Berlin");
        // 2016-05-25 12:00
        LocalDateTime dateTime = LocalDateTime.of(2016, 05, 25, 12, 0);
        // 2016-05-25 13:00, Europe/Berlin (+01:00)
        ZonedDateTime berlinDateTime = ZonedDateTime.of(dateTime, berlin);
        // 2016-05-25 03:00, America/Los_Angeles (-08:00)

        ZonedDateTime losAngelesDateTime = berlinDateTime.withZoneSameInstant(losAngeles);
        int offsetInSeconds = losAngelesDateTime.getOffset().getTotalSeconds(); // -28800


    }
}
