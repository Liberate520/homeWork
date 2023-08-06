package tree;

import human.Gender;

import java.time.LocalDate;

public interface TreeItem<T> {
    LocalDate getDateOfdDeath();
    String getFullName();
    String getChildren();

    T getFather();
    T getMather();
    String getFirstName();
    String getLastName();
    String getSurName();
    Gender getGender();
    LocalDate getDateOfBirth();




}
