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

        Map<LocalDateTime, Integer> test1 = new HashMap<>() {{
            put(LocalDateTime.now().plusDays(1), 2);
            put(LocalDateTime.now().plusDays(2), 2);
        }};

        Map<LocalDateTime, Integer> test2 = new HashMap<>() {{
                put(LocalDateTime.now().plusDays(3), 0);
                put(LocalDateTime.now().plusDays(4), 10);
        }};

        return Arrays.asList(new Object[][]{
                {test1, 2, new BigDecimal(2)},
                {test2, 2, new BigDecimal(5)},

        });

    }

    private final Map<Timestamp, Integer> integers;
    private final int month;
    private final BigDecimal expectedAverage;

    public AccountingTest(Map<Timestamp, Integer> integers,
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