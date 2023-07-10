package familyTree.src.family_tree.family_tree1;


import java.io.Serializable;
import java.time.LocalDate;

public interface FamilyTreeItem extends Serializable, Comparable {
    String getName();

    Object getParents();

    Object getChildren();

    Object getDocId();

    LocalDate birthDate();

    <T> Comparable<T> getBirthDate();

}
