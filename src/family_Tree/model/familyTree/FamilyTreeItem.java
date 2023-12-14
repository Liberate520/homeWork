package family_Tree.model.familyTree;

import family_Tree.model.human.Gender;

import java.time.LocalDate;
import java.util.List;

public interface FamilyTreeItem<T> {
    void setDateOfDeath(LocalDate dateOfDeath);
    void setMother(T mother);
    void setFather(T father);
    int getId();
    String getName();
    Gender getGender();
    List<T> getChildren();
    String getFatherInfo();
    String getMotherInfo();
    String getChildrenInfo();
    boolean addChild(T child);
    boolean addParent(T parent);
    List<T> getParents();
    String getAge();
    String getInfo();
}
