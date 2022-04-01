import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
@Nested
class LargeStringTest {
    private String str;

    @BeforeEach
    void setLargeString(){
        str = "abcdefghijklmnopqrstuvwxyz";
    }

    @Test
    @DisplayName("Length should be 26")
    void lengthIsTwentySix(){
        assertEquals(26, str.length());
    }
    @Test
    @DisplayName("String to upper case")
    void tuUpperCaseIsZero(){
        String result = str.toUpperCase();
        assertEquals(result, str.toUpperCase());
    }
}