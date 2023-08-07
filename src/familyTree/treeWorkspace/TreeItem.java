package familyTree.treeWorkspace;

import familyTree.enums.Gender;

public interface TreeItem<E> extends Comparable<E>{
    int getId();
    String getName();
    Gender getGender();
    int getAge();
    E addChildren(E child);
    E addParent(E parent);
    int compareTo(E person);
}
