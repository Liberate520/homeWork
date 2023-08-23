package homeWork.model.FamilyTree;

import java.io.Serializable;
import java.util.List;

import homeWork.model.human.Human;

public interface TreeItem<E> extends Serializable {
    String getName();

    int getAge();

    E getFather();

    E getMother();

    String getChildrenInfo();

    boolean addParent(E parent);

    boolean addChild(E child);

    List<E> getChildren();

    List<E> getParents();
}
