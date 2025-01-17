

import static org.junit.jupiter.api.Assertions.*;

import org.example.StringCal;
import org.junit.jupiter.api.Test;

public class StringCalTest {


    private final StringCal calculator = new StringCal();


    @Test
    void testSingleNumber() {
        assertEquals(2, calculator.add("2"));
    }

    @Test
    void testEmptyString() {
        assertEquals(0, calculator.add(""));

    }

    //output like : 1\n2\n3 = 6;
    // 1 + 2 + 3 = 6
    @Test
    void testMultipleNumbersWithDefaultDelimiter() {
        assertEquals(6, calculator.add("1,2,3"));
    }

    @Test
    void testMultipleNumbersWithNewlineDelimiter() {
        assertEquals(6, calculator.add("1\n2\n3"));
    }

    @Test
    void testCustomDelimiter() {
        assertEquals(6, calculator.add("//;\n1;2;3"));
    }

    @Test
    void testMixedDelimiters() {
        assertEquals(6, calculator.add("1,2\n3"));
    }

    @Test
    void testCustomDelimiterDifferent() {
        assertEquals(6, calculator.add("//*\n1*2*3"));
    }


    @Test
    void testNegativeNumbers() {
        assertThrows(NumberFormatException.class, () -> {
            calculator.add("//;\n-1;2;3");
        });
    }
    @Test
    void testSingleNegativeNumber() {
        assertThrows(IllegalArgumentException.class, () -> {
            calculator.add("-5");
        });
    }


    @Test
    void testMultipleDelimitersWithEmptyNumbers() {
        assertEquals(0, calculator.add("1,,2,,3"));
    }


}



