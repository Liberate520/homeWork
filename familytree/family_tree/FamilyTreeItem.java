package familytree.family_tree;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import familytree.human.Human;


public interface FamilyTreeItem<T> extends Serializable{
    T getFather();
    T getMother();
    void addChild(T human);
    void addParent(T human);
    String getName();
    String getSurname();
    Date getDateOfBirth();
    Date getDateOfDeath();
    List<T> getParents();
    List<T> getChildren();
    T getSpouse();
    void addSpouse(T human);
}
