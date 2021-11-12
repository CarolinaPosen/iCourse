package by.itacademy.mikhalevich.icourse.logic.calculating;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

public class Accounting {

    public static BigDecimal average(List<BigDecimal> value, int countOfMonth) {
        BigDecimal[] totalWithCount =
                value.stream()
                 .skip(value.size() - countOfMonth)
                .filter(bd -> bd != null)
                .map(bd -> new BigDecimal[]{bd, BigDecimal.ONE})
                .reduce((a, b) -> new BigDecimal[]{a[0].add(b[0]), a[1].add(BigDecimal.ONE)})
                .get();
        BigDecimal mean = totalWithCount[0].divide(totalWithCount[1], RoundingMode.HALF_UP);
        return mean;
    }

}
