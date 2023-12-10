package family_tree.family_tree.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

public interface GeneralTypeTree<G> extends Serializable {
    void setId(long id);
    long getId();
    G getFather();
    G getMother();
    boolean addChild(G human);
    boolean addParent(G human);
    String getName();
    int getAge();
    LocalDate getDeathDate();
    LocalDate getBirthDate();
    List<G> getParents();
    List<G> getChildren();
    G getSpouse();
    void setSpouse(G human);

}
