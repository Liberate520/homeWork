//package treePackage;

import java.util.List;

public interface HumanInterface<E> extends Iterable<E> {

    
    Object humanForSort = null;

    List<E> getHumanList();
    
    void addHumanForSort(E human);

}
