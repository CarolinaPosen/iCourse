package by.itacademy.mikhalevich.icourse.logic.calculating;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class Accounting {
    /**
     * Returns a {@link BigDecimal} average of {@link List<Integer>}
     * @param value {@link List<Integer>}
     * @return {@link BigDecimal}
     */
/*    public static BigDecimal average(List<BigDecimal> value, int countOfMonth) {
        double average = value.stream()
                .mapToInt(i -> i)
                .skip(value.size() - countOfMonth)
                .average()
                .orElse(0.0);
        return new BigDecimal(average);
    }*/

/*    public static BigDecimal average(Map<Timestamp, Integer> integers, int countOfMonth) {
        double average = integers.entrySet().stream()
                .mapToInt(i -> i.getValue())
                .skip(integers.size() - countOfMonth)
                .average()
                .orElse(0.0);
        return new BigDecimal(average);
    }*/

    public static BigDecimal average(List<BigDecimal> value, int countOfMonth) {
        BigDecimal sum = value.stream()
                .map(Objects::requireNonNull)
                .skip(value.size() - countOfMonth)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
        long count = value.stream().filter(Objects::nonNull).count();
        return sum.divide(new BigDecimal(count), RoundingMode.HALF_UP);
    }

}
