package family_tree.model.tree;

import java.util.List;

public interface FamilyTreeItem<E, K> extends Comparable<E>{
    int getId();
    String getName();
    String getSurname();
    String getPatronymic();
    boolean addKinship(E human, K kinship);
    boolean removeKinship(E kinship);
    E getMother();
    E getFather();
    List<E> getParents();
    List<E> getChildren();
    List<E> getKinshipList();
    int getAgeHuman();
}