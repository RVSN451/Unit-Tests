
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;


class PersonTest {

    @Test
    public void valueDateOfBirth_thenCorrect() {
        Person person = new Person("Sergry", "Petrov", LocalDate.of(1980, 12, 12),
                Sex.MALE, Education.HIGHER);

        assertThat(person, hasProperty("dateOfBirth"));
    }

    @Test
    public void giveValueFamily_thenCorrect() {
        Person person = new Person("Sergry", "Petrov", LocalDate.of(1980, 12, 12),
                Sex.MALE, Education.HIGHER);

        assertThat(person, Matchers.hasProperty("family", equalTo("Petrov")));
    }

    @Test
    public void keyFoundInMap_thenCorrect() {

        Map<Integer, Person> map = new HashMap<>();
        Person person1 = new Person("Sergry", "Petrov",
                LocalDate.of(1980, 12, 12),
                Sex.MALE, Education.HIGHER);
        Person person2 = new Person("Yriy", "Gagarin",
                LocalDate.of(1981, 12, 20),
                Sex.MALE, Education.HIGHER);

        map.put(1, person1);
        map.put(2, person2);
        assertThat(map, hasKey(2));
    }

    @Test
    public void valueFoundInMap_thenCorrect() {

        Map<Integer, Person> map = new HashMap<>();
        Person person1 = new Person("Sergry", "Petrov",
                LocalDate.of(1980, 12, 12),
                Sex.MALE, Education.HIGHER);
        Person person2 = new Person("Yriy", "Gagarin",
                LocalDate.of(1981, 12, 20),
                Sex.MALE, Education.HIGHER);

        map.put(1, person1);
        map.put(2, person1);
        assertThat(map, hasValue(person1));
    }
}