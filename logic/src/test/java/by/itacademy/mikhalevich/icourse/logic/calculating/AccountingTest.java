package by.itacademy.mikhalevich.icourse.logic.calculating;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class AccountingTest {

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {List.of(2, 2), 2, new BigDecimal(2)},
                {List.of(1, 2), 1, new BigDecimal(2)},
                {List.of(0, 0), 0, new BigDecimal(0)}
        });
    }

    private final List<Integer> integers;
    private final int month;
    private final BigDecimal expectedAverage;

    public AccountingTest(List<Integer> integers,
                          int month,
                          BigDecimal expectedAverage) {

        this.integers = integers;
        this.month = month;
        this.expectedAverage = expectedAverage;
    }

    @Test
    public void shouldReturnCorrectSum() {
        assertSame(expectedAverage.stripTrailingZeros(), Accounting.average(integers, month).stripTrailingZeros());
    }
}