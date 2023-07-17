package family_tree.familytree;

import family_tree.person.Gender;
import java.io.Serializable;
import java.util.List;

public interface FamilyTreeItem<T> extends Serializable {

    void setMother(T mother);
    void setMotherForcedly(T mother);
    void setFather(T father);
    void setFatherForcedly(T father);
    void setChildren(T child);
    void setBirthDate(int year, int month, int day);
    void setEndLifeDate(int year, int month, int day);
    void setGender(Gender gender);
    void setCommit(String commit);
    void setFullname(String fullname);
    String getName();
    String getBirthDate();
    String getEndLifeDate();
    Gender getGender();
    T getMother();
    T getFather();
    String getChildrenStr();
    List<T> getChildren();
    String getCommit();
    int getAge();
    String printShort();
}
