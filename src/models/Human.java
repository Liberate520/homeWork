package models;

import java.time.LocalDate;

public record Human(String firstName, String secondName, Gender gender, LocalDate birthDate) {
    @Override
    public String toString() {
        return this.firstName() +
                " " +
                this.secondName() +
                " " +
                this.birthDate();
    }
}
