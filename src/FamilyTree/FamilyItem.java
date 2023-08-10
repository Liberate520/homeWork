package FamilyTree;

import java.util.List;

public interface FamilyItem<E> {
    String getName();
    int getAge();
    void setId(long id);
    long getId();
    boolean addMother(E human);
    boolean addFather(E human);
    List<E> getParents();
    boolean addChild(E human);
    List<E> getChildren();
    String getGender();
    void setSpouse(E human);
    E getSpouse();
}
