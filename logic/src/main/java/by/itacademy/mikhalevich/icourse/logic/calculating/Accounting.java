package by.itacademy.mikhalevich.icourse.logic.calculating;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Accounting {
    /**
     * Returns a {@link BigDecimal} average of {@link List<Integer>}
     * @param integers {@link List<Integer>}
     * @return {@link BigDecimal}
     */
/*    public static BigDecimal average(List<Integer> integers, int countOfMonth) {
        double average = integers.stream()
                .mapToInt(i -> i)
                .skip(integers.size() - countOfMonth)
                .average()
                .orElse(0.0);
        return new BigDecimal(average);
    }*/

    public static BigDecimal average(Map<Timestamp, Integer> integers, int countOfMonth) {
        double average = integers.entrySet().stream()
                .mapToInt(i -> i.getValue())
                .skip(integers.size() - countOfMonth)
                .average()
                .orElse(0.0);
        return new BigDecimal(average);
    }

}
