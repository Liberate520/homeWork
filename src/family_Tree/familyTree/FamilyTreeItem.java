package family_Tree.familyTree;

import family_Tree.human.Gender;

import java.time.LocalDate;
import java.util.List;

public interface FamilyTreeItem<T> {
    void setId(int id);
    void setName(String name);
    void setDateOfBirth(LocalDate dateOfBirth);
    void setDateOfDeath(LocalDate dateOfDeath);
    void setGender(Gender gender);
    void setMother(T mother);
    void setFather(T father);
    void setChildren(List<T> children);
    int getId();
    String getName();
    LocalDate getDateOfBirth();
    LocalDate getDateOfDeath();
    Gender getGender();
    T getMother();
    T getFather();
    List<T> getChildren();
    String getFatherInfo();
    String getMotherInfo();
    String getChildrenInfo();
    boolean addChild(T child);
    boolean addParent(T parent);
    List<T> getParents();
    String getAge();
    int getPeriod(LocalDate start, LocalDate end);
    String getInfo();
}
