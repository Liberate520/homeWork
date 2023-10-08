package FamTree;

import Human.Gender;
import Human.Human;

import java.util.List;

public interface TreeMembers<T> {
    void setId(long id);
    long getId();
    String getFirstName();
    String getLastName();
    void setLastName(String lastName);
    Gender getSex();
    T getFather();
    T getMother();
    void setFather(T father);
    List<T> getChildren();
    int getAge();
    void addChildren(T... children);
    String getChildrenInf();
    String getInfo();
}