package familytree.Tree;

import java.util.List;

public interface GetByOn {
    String getName();
    String getSurname();
  
    <E> void addChild(E child);

    <E> void addPartner(E partner);
    <E> void addParent(E parent);

    Person[] getChildren();
}