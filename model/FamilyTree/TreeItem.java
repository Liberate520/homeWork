package homeWork.model.FamilyTree;

import java.io.Serializable;
import java.util.List;

import homeWork.model.human.Human;

public interface TreeItem<T> extends Serializable {
    String getName();

    int getAge();

    T getFather();

    T getMother();

    String getChildrenInfo();

    boolean addParent(T parent);

    boolean addChild(T child);

    List<T> getChildren();

    List<T> getParents();
}
