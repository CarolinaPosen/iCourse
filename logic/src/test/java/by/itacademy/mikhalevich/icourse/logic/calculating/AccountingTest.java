package by.itacademy.mikhalevich.icourse.logic.calculating;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.*;

import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class AccountingTest {

    @Parameterized.Parameters
    public static Collection<Object[]> data() {

        List<BigDecimal> test1 = List.of(new BigDecimal(2), new BigDecimal(2));
        List<BigDecimal> test2 = List.of(new BigDecimal(10), new BigDecimal(5));

        return Arrays.asList(new Object[][]{
                {test1, 2, new BigDecimal(2)},
                {test2, 2, new BigDecimal(5)},

        });

    }

    private final List<BigDecimal> sum;
    private final int month;
    private final BigDecimal expectedAverage;

    public AccountingTest(List<BigDecimal> sum,
                          int month,
                          BigDecimal expectedAverage) {

        this.sum = sum;
        this.month = month;
        this.expectedAverage = expectedAverage;
    }

    @Test
    public void shouldReturnCorrectSum() {
        assertSame(expectedAverage.stripTrailingZeros(), Accounting.average(sum, month).stripTrailingZeros());
    }
}