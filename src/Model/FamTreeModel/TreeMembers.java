package Model.FamTreeModel;

import Model.FamTreeModel.Human.Gender;
import Model.FamTreeModel.Human.Member;

import java.util.Set;

public interface TreeMembers<E extends Member> {
//    void setId(long id);
//    long getId();
//    String getFirstName();
//    String getLastName();
//    void setLastName(String lastName);
//    Gender getSex();
//    T getFather();
//    T getMother();
//    void setFather(T father);
//    List<T> getChildren();
//    int getAge();


    void addChildren(Member... children);

    long getId();

    void setId(long id);

    String getFirstName();

    String getLastName();

    void setLastName(String lastName);

    Gender getSex();

    int getAge();
    void setAge(int age);
    Member getFather();

    Member getMother();

    Set<Member> getChildren();


    String getInfo();
}