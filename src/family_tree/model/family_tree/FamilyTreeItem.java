package family_tree.model.family_tree;

import family_tree.model.human.Gender;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

public interface FamilyTreeItem<T> extends Serializable {
    long getId();
    String getFirstName();
    String getMiddleName();
    String getLastName();
    int getAge();
    LocalDate getDateOfBirth();
    T getMother();
    T getFather();
    Gender getGender();
    T getSpouse();
    List<T> getChildren();
    void setId(long id);
    void setSpouse(T human);
    void setChildren(List<T> children);
    //void setChildren(ArrayList<T> child);
    void addChildren(T child);
    void addFather(T human);
    void addMother(T human);

}
