package FamilyTree.FamilyTree.Model.Tree;

import java.time.LocalDate;
import java.util.List;

import FamilyTree.FamilyTree.Model.Person.Gender;
import FamilyTree.FamilyTree.Model.Person.Person;

public interface TreeItem<E> {
    int setId(int humansId);
    long getId();
    String getName();
    Gender getGender();
    LocalDate getBirthDate();
    LocalDate getDeathDate();
    List<Person> getChildren();
    Person getSpouse();
    List<Person> getParents();
    void addSpouse(Person spouse);
    void addChild(Person child);
    void addParent(Person parent);

}
