

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


}



