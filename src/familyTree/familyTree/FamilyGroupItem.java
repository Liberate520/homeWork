package familyTree.familyTree;

import familyTree.human.Gender;
import familyTree.human.Human;

import java.time.LocalDate;
import java.util.List;

public interface FamilyGroupItem<T> {
    boolean addChild(T value);

    void addParent(T value);

    long getId();

    void setId(int id);

    String getName();

    void setName(String name);
    LocalDate getDateOfBirth();
//    void setDateOfBirth(LocalDate dateOfBirth);
    LocalDate getDateOfDeath();
    int getAge();
    Gender getGender();
    T getMother();
    T getFather();
    List<T> getChildren();
    T getSpouse();
    void setSpouse(T value);
    void setDevorce(T value);
//    String getMotherInfo();

    void addToParents(T value);
    void addToChilderen(T value);
}
