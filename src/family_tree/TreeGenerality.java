package family_tree;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

public interface TreeGenerality<T> extends Serializable {
    void setId(int id);
    int getId();
    int getAge();
    T getFather();
    T getMother();
    void addChild(T human);
    void addParent(T human);
    String getName();
    List<T> getParents();
    List<T> getChildren();
    T getPartner();
    void setPartner(T human);
}
