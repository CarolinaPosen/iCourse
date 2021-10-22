package by.itacademy.mikhalevich.icourse.logic.calculating;

import java.math.BigDecimal;
import java.util.List;

public class Accounting {
    /**
     * Returns a {@link BigDecimal} average of {@link List<Integer>}
     * @param integers {@link List<Integer>}
     * @return {@link BigDecimal}
     */
    public static BigDecimal average(List<Integer> integers, int countOfMonth) {
        double average = integers.stream()
                .mapToInt(i -> i)
                .skip(integers.size() - countOfMonth)
                .average()
                .orElse(0.0);
        return new BigDecimal(average);
    }
}
