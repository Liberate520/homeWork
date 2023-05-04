package model.tree;

import java.util.List;

import model.human.Gender;
public interface TreeItem<T> {
    int getAge();
    T getMother();
    T getFather();
    Gender getGender();
    List<T> getChildrens();
    void addChildren(T t);
    void removeChildren(T t);
    String getChildrenInfo(List<T> list);
    String getFullName();
    String getFullInfo();
    String getShortInfo();
    void addParent(T t);
    void removeParent(T t);
}
