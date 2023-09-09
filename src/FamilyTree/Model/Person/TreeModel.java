package family_tree.FamilyTree.Model.Person;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.HashSet;

public interface TreeModel<T> extends Serializable {
    int getInn();
    T getMother();
    T getFather();
    T getHusband();
    String getName();
    LocalDate getDataBirth();
    HashSet<T> getChildren();

    void setParents(T fParent, T sParent);
    void setInn(int valueInn);

    void addParent(T parent);
    void addChildren(T children);

    boolean setHusband(T partner);
    boolean divorce(T partner);

}
