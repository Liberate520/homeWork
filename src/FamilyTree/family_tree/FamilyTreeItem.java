package FamilyTree.family_tree;

import java.time.LocalDate;
import java.util.List;

import FamilyTree.KindOfAnimal.Gender;
import FamilyTree.KindOfAnimal.Human;

public interface FamilyTreeItem {
    int setId(long humansId);
    long getId();
    String getName();
    Gender getGender();
    LocalDate getBirthDate();
    LocalDate getDeathDate();
    List<Human> getChildren();
    void getParents();

    
    void getSpouse();
    void setSpouse();
    void addChild();
    void addParent();
}
