package family_tree;

import human.Gender;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

public interface FamilyTreeItem<E> extends Serializable {
    int getId();
    void setId(int id);
    int getAge();
    String getName();
    String getSurname();
    String getPatronymic();
    LocalDate getBirth();
    Gender getGender();
    E getMother();
    E getFather();
    List<E> getChildren();

    <E extends FamilyTreeItem<E>> void setChildren(List<E> children);

    void setFather(E father);

    void setMother(E mother);
}
