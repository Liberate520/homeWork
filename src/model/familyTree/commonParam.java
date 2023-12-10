package model.familyTree;

import java.util.List;
import java.time.LocalDate;

public interface commonParam<E> {
    int getId();
    //    long getId();
    void setId(int id);
//    void setId(long id);

    String getName();

//    <E> void addChild(E human);
//    <E> void addParent(E human);
    boolean addChild(E human);
    boolean addParent(E human);

    List<E> getParents();
    List<E> getChildren();
//    void getParents();
//    void getChildren();

    LocalDate getBirthDate();
    LocalDate getDeathDate();

    int getAge();

    E getFather();
    E getMother();

    E getSpouse();
    void setSpouse(E human);

}
