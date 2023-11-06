package my_family_tree.tree;

import java.time.LocalDate;
import java.util.List;

public interface TreeItem {
    int getAge();
    String getName();
    E getSpouse();
    LocalDate getBirthDay();
    void setId(int id);
    int getId();
    List<> getParents();
    List<> getChildren();
    void addParents();
    void addChildren();
    void setSpouse();
}
