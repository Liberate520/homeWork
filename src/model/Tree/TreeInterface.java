package model.Tree;

import model.People.Gender;
import model.People.Person;

import java.util.List;

public interface TreeInterface {

    int getId();

    String getFirstName();

    String getLastName();

    Person getMother();

    Person getFather();

    Gender getGender();

    String getInfo();

    String getMotherInfo();

    String getFatherInfo();

    List<Person> getDescendants();

    List<String> getDescendantInfo();

    @Override
    boolean equals(Object obj);

    @Override
    String toString();

    int compareTo(Person o);
}
