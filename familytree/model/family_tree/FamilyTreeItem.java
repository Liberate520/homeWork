package familytree.model.family_tree;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

import familytree.model.human.Human;


public interface FamilyTreeItem<T> extends Serializable{
    T getFather();
    T getMother();
    void addChild(T human);
    void addParent(T human);
    String getName();
    String getSurname();
    LocalDate getDateOfBirth();
    LocalDate getDateOfDeath();
    List<T> getParents();
    List<T> getChildren();
    T getSpouse();
    void addSpouse(T human);
}
