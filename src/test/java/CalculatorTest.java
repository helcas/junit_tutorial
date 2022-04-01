import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {

  @BeforeAll
  static void beforeAll(){
    System.out.println("Initialize Connection to Database");
  }
  @AfterAll
  static void afterAll(){
    System.out.println("Close Connection to Database");
  }
@BeforeEach
void beforeEach(TestInfo info){
  System.out.println("Initialize Test Data before each Test " + info.getDisplayName());
}
@AfterEach
void afterEach(TestInfo info){
  System.out.println("Clean up data " + info.getDisplayName());
}
  @Test
   void whatEverYouWant() {
    int actualLength = "ABCD".length();
    int expectedLength = 4;
    assertEquals(expectedLength, actualLength);
  }

  @Test
  void toUpperCase(){
    String str = "abcd";
    String result = str.toUpperCase();
assertEquals("ABCD", result);
assertNotNull(result);
  }
  @Test
  @RepeatedTest(10)
  void contains(){
    assertFalse("abcdefgh".contains("ijk"));
  }

  @Test
  void split(){
    String str = "abc def ghi";
    String actualResult[] = str.split(" ");
    String[] expectedResult = new String[] {"abc", "def", "ghi"};
    assertArrayEquals(expectedResult, actualResult);
  }

  @Test
  @DisplayName("When length is Null, throw an exception.")
  void length_exception(){
  String str = null;
  assertThrows(NullPointerException.class,
          () -> {str.length();}
          );
  }
  @ParameterizedTest
  @ValueSource(strings = {"ABCD","ABC", "A", "ABCD" })
  void length_greater_that_Zero(String str){
  assertTrue(str.length() > 0);
  }
  @ParameterizedTest(name = "{0} toUpperCase is {1}")
  @CsvSource(value = {"abcd, ABCD", "abc, ABC", "'',''", "abcdefg, ABCDEFG" })
  void toUpperCase(String word, String capWord){
assertEquals(capWord, word.toUpperCase());
  }
  @ParameterizedTest(name = "{0} length is {1}")
  @CsvSource(value = {"abcd, 4", "abc, 3", "'',0", "abcdefg, 7" })
  void stringLength(String word,int expectedLength){
    assertEquals(expectedLength, word.length());
  }

  @Test
  @Disabled
  void performanceTest(){
    assertTimeout(Duration.ofSeconds(5),
            () -> {
            for (int i = 0; i< 1000000; i++){
              int j = i;
              System.out.println(j);
            }
            });
  }
}