package model;

public interface FamilyTreeItem<T> {
    String getFullName();
    int getAge();
    FamilyTreeItem getFather();
    FamilyTreeItem getMother();
    void addKid(T human);


}
