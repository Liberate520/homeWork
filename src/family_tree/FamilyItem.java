package family_tree;

import human.Human;

import java.time.LocalDate;
import java.util.List;

public interface FamilyItem<E> {
    LocalDate getDateOfBirth();
    String getName();
    void setId(int id);
    int getId();
    List<E> getChildren();
    String getSpouseInfo();

    Object getSpouse();

    List<Human> getParents();

    boolean addParent(E human);
}
