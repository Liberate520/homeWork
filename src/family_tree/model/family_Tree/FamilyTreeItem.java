package familyTree.src.family_tree.model.family_Tree;


import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

public interface FamilyTreeItem<T> extends Serializable, Comparable {
    String getName();

    List<T> getParents();

    List<T> getChildren();

    Object getDocId();

    LocalDate birthDate();

    <T> Comparable<T> getBirthDate();

    boolean addChild(T human);

    boolean addParent(T human);
}
