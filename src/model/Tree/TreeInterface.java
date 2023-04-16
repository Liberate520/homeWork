package model.Tree;

import model.People.Gender;
import model.People.Person;

import java.util.Iterator;
import java.util.List;

public interface TreeInterface<E> {
    boolean addPerson(E person);
    List<String> searchPerson();
    List<String> searchPersonDescendance();
    String getTreeInfo();
    List<E> getFamilyTree();
    Iterator<E> iterator();
    boolean addDescendants();
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

    List<Person> getDescendantInfo();

    @Override
    boolean equals(Object obj);

    @Override
    String toString();

    int compareTo(Person o);

}
