import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.time.LocalDate;

class MainTest {

    @Test
    void isDigit_success() {
        System.out.println("isDigit_success: ");
        String input = "5";
        boolean expected = true;
        Boolean actual = Main.isDigit(input);
        Assertions.assertTrue(expected);
    }


    @ParameterizedTest
    @ValueSource(strings = {"P", "_", "5j"})
    void isDigitWithStringParameter_failure(String argument) {
        System.out.println("isDigit_failure: ");
        boolean expected = false;
        Boolean actual = Main.isDigit(argument);
        Assertions.assertFalse(expected);
    }

    @Test
    void randomDateOfBirth() {
        System.out.println("randomDateOfBirth_success: ");
        LocalDate expected = LocalDate.MAX;
        LocalDate actual = Main.randomDateOfBirth();
        Assertions.assertEquals(actual.getClass(), expected.getClass());
    }


}