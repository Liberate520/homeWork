package models;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static models.Gender.MALE;
import static org.junit.jupiter.api.Assertions.assertEquals;

class HumanTest {
    private Human human;

    @BeforeEach
    void setUp() {
        this.human = new Human("Pavel", "XXX", MALE, LocalDate.of(2022, 1, 15));
    }

    @Test
    void creationTest() {
        assertEquals("Pavel", this.human.firstName());
        assertEquals("XXX", this.human.secondName());
        assertEquals(MALE, this.human.gender());
        assertEquals(LocalDate.of(2022, 1, 15), this.human.birthDate());
        String humanString = this.human.firstName() + " " + this.human.secondName() + " " + this.human.birthDate();
        assertEquals(humanString, this.human.toString());
    }
}