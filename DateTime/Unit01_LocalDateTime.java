package DateTime;

import java.time.*;
import java.time.temporal.TemporalAdjusters;

import static java.time.temporal.TemporalAdjusters.*;

public class Unit01_LocalDateTime {
    public static void main(String[] args) {

        // Khởi tạo ngày tháng năm hiện tại
        LocalDate today = LocalDate.now();
        // Khởi tạo ngày 2016-05-25
        LocalDate tenthFeb2014 = LocalDate.of(2016, Month.MAY, 25);
        // hoặc 1981-09-01
        LocalDate firstSep1981 = LocalDate.of(1981, 9, 1);
        // Khởi tạo ngày thứ 65 của năm 2016 (2016-03-06)
        LocalDate sixtyFifthDayOf2010 = LocalDate.ofYearDay(2016, 65);

        //Khi ta muốn làm việc với thời gian (giờ, phút, giây) ta dùng lớp LocalTime.
        // Khởi tạo giờ hiện tại
        LocalTime currentTime = LocalTime.now();
        // hay lúc 12 giờ trưa
        LocalTime midday = LocalTime.of(12, 0);
        // 13:30:15
        LocalTime afterMidday = LocalTime.of(13, 30, 15);
        // hay giây thứ 12345 của một ngày là (03:25:45)
        LocalTime fromSecondsOfDay = LocalTime.ofSecondOfDay(12345);

        // Khởi tạo ngày giờ hiện tại
        LocalDateTime currentDateTime = LocalDateTime.now();
        // hay 2016-05-25 12:30
        LocalDateTime twentyMay2016 = LocalDateTime.of(2016, 5, 25, 12, 30);
        // hay
        LocalDateTime christmas2014 = LocalDateTime.of(2016, Month.MAY, 25, 12, 30);

        // Thời gian theo Hà Nội
        LocalTime currentTimeInHaNoi = LocalTime.now(ZoneId.of("Asia/Jakarta"));
        //hay UTC time zone
        LocalTime nowInUtc = LocalTime.now(Clock.systemUTC());
//======================================================================================================

        //Một số hàm cho ngày
        LocalDate date = LocalDate.of(2016, 5, 15);
        boolean isBefore = LocalDate.now().isBefore(date);
        // => trả về true/false
        // Lấy tên của tháng
        Month may = date.getMonth();// => MAY
        // Lấy tháng dạng số
        int mayValue = may.getValue(); // 5
        // Lấy số ngày lớn nhất/nhỏ nhất của tháng (thay đổi theo năm nhuân, không nhuận)
        LocalDate date2 = LocalDate.of(2016, 2, 15);
        Month february = date2.getMonth();// => FEBRUARY
        int minLength = february.minLength(); // 28
        int maxLength = february.maxLength(); // 29
        // Lấy tháng trước tháng hiện tại
        Month firstMonthOfQuarter = february.firstMonthOfQuarter(); // JANUARY
        // Lấy ngày sau ngày hôm nay
        LocalDate tomorrow = LocalDate.now().plusDays(1);
        // Trước hiện tại 5 giờ and 30 phút
        LocalDateTime dateTime = LocalDateTime.now().minusHours(5).minusMinutes(30);
        // Lấy ngày đầu tiên của tháng
        LocalDate firstDayOfMonth = date.with(TemporalAdjusters.firstDayOfMonth());
        // => 2016-05-01
        // Lấy ngày cuối của tháng
        LocalDate lastDayOfMonth = date.with(TemporalAdjusters.lastDayOfMonth());
        // => 2016-05-31

        //Tiện ích hơn nhiều khi ta import static FirstMonthOfQuarter.*
        // 2016-05-31
        LocalDate lastDayOfYear = date.with(lastDayOfYear());
        // 2016-05-01
        LocalDate firstDayOfNextMonth = date.with(firstDayOfNextMonth());
        // Chủ nhật tiếp theo
        LocalDate nextSunday = date.with(next(DayOfWeek.SUNDAY));

        //Một số hàm cho năm
        int year = date.getYear(); // 2016
        int dayOfYear = date.getDayOfYear(); // 46
        int lengthOfYear = date.lengthOfYear(); // 365
        boolean isLeapYear = date.isLeapYear(); // false
        DayOfWeek dayOfWeek = date.getDayOfWeek();
        int dayOfWeekIntValue = dayOfWeek.getValue(); // 6
        String dayOfWeekName = dayOfWeek.name(); // SATURDAY
        int dayOfMonth = date.getDayOfMonth(); // 25
        LocalDateTime startOfDay = date.atStartOfDay(); // 2016-05-25 00:00
        // Một số hàm đặc biệt khác cho năm
        Year currentYear = Year.now();
        Year twoThousand = Year.of(2000);
        boolean isLeap = currentYear.isLeap(); // false
        int length = currentYear.length(); // 365
        // sixtyFourth day of 2014 (2014-03-05)
       // LocalDate date2 = Year.of(2014).atDay(64);

    }
}
