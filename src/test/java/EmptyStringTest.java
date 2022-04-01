import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
    @Nested
    @DisplayName("For an empty String")
    class EmptyStringTest {
    private String str;

    @BeforeEach
    void setToEmpty(){
    str = "";
    }

    @Test
    @DisplayName("Length should be zero")
        void lengthIsZero(){
        assertEquals(0, str.length());
    }
    @Test
    @DisplayName("Upper case is empty")
        void tuUpperCaseIsZero(){
        assertEquals("", str.toUpperCase());
    }
}