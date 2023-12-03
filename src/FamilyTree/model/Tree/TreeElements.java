package FamilyTree.model.Tree;

import java.time.LocalDate;

public interface TreeElements<T>{
    T getMother();
    T getFather();
    int getId();

    void addMother(T person);
    void addFather(T person);
    //void addChild(T person);

    void setMarriage(T spouse2, LocalDate date);
    void setDivorce (T spouse2, LocalDate date);

    void setDead(LocalDate date);
}
