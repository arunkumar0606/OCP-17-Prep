package ch_4;

import java.time.*;
import java.time.temporal.ChronoUnit;

public class DateAndTimeEx {
    public static void main(String[] args) {
        LocalDate d1= LocalDate.now();
        LocalTime t1 = LocalTime.now();
        LocalDateTime dt1 = LocalDateTime.now();
        ZonedDateTime zdt1 = ZonedDateTime.now();
        System.out.println(d1); // 2024-06-01
        System.out.println(t1); // 14:30:45.123
        System.out.println(dt1); // 2024-06-01T14:30
        System.out.println(zdt1); // 2024-06-01T14:30:45.123+02:00[Europe/Berlin]

        /*
        Different cons for LocalDate, LocalTime, LocalDateTime, ZonedDateTime
        Period - amount of time in terms of years, months, days
        Duration - amount of time in terms of seconds, nanoseconds
         */
        //days -D , months - M, years - Y
        var p1= Period.of(1,2,3);
        var d2 = d1.plus(p1);
        System.out.println(d2); // 2025-08-04
        System.out.println(Period.of(1,2,3));   // P1Y2M3D

        //Duration
        // hours - H, minutes - M, seconds - S
        var d3 = Duration.ofHours(5);
        var t2 = t1.plus(d3);
        System.out.println(t2); // 19:30:45.123

        System.out.println(Duration.ofDays(5)); // PT120H
        var daily = Duration.of(1, ChronoUnit.DAYS);
        System.out.println(daily); // PT24H
        //LocalTime truncated = time.truncatedTo(ChronoUnit.MINUTES);

        //Instant
        /*
        Instant.now()       → exact moment in UTC — machine time — has no timezone
        LocalDateTime.now() → date + time in YOUR system's timezone — has no UTC info
         */
        var i = Instant.now();
        System.out.println(LocalDateTime.now());
        System.out.println(i); // 2024-06-01T12:30:

        // we can convert zonedDateTime to instant
        var zdt2 = ZonedDateTime.now();
        var i2 = zdt2.toInstant();
        System.out.println(i2); // 2024-06-01T12:30:45.123Z

        //DayLightSavingTime
        System.out.println("---------------------");
        //March 13
        //November 6
        // US GMT -5, in summer -4
        //March 13 -> 2:00 -> 3:00
        //November 6 -> 2:00 -> 1:00
    }
}
