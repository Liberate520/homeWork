package tree;

import human.Gender;

import java.time.LocalDate;

public interface TreeItem<T> {
    LocalDate getDateOfdDeath();
    String getFullName();
    String getChildren();

    String getFirstName();
    Gender getGender();
    LocalDate getDateOfBirth();




}
