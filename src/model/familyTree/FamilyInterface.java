package model.familyTree;

import java.util.List;

public interface FamilyInterface<E> extends Iterable<E> {

    
    List<E> getHumanList();
    
    void addHumanForSort(E human);

}
