package familyTree.familyTree;

import familyTree.human.Gender;
import familyTree.human.Human;

import java.time.LocalDate;
import java.util.List;

public interface FamilyGroupItem<T> {

    void setId(long id);

    long getId();

    T getMother();

    T getFather();

    boolean addChild(T value);

    void addParent(T value);

    String getName();

    LocalDate getDateOfDeath();

    LocalDate getDateOfBirth();

    List<T> getChildren();

    T getSpouse();

    void setSpouse(T value);

    int getAge();
//    void setName(String name);
//    Gender getGender();
//    void setDevorce(T value);
//    void addToParents(T value);
//    void addToChilderen(T value);
//    void setDateOfBirth(LocalDate dateOfBirth);

}
