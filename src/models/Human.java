package models;

import java.util.Date;

public record Human(String firstName, String secondName, Gender gender, Date birthDate) {
}
