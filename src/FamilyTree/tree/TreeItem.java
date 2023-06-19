package FamilyTree.tree;

import FamilyTree.person.Person;

import java.time.LocalDate;

public interface TreeItem {
    String getName();
    LocalDate getDateOfBirth();

    Person getMother();

    Person getFather();

    String getPersonInfo();
}
