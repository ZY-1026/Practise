package leetCode.letcode1360;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Solution {
    public int daysBetweenDates(String date1, String date2) {
        LocalDate startDate = LocalDate.parse(date1);
        LocalDate endDate = LocalDate.parse(date2);
        long dis = ChronoUnit.DAYS.between(startDate, endDate);
        return Math.abs((int) dis);
    }
}
