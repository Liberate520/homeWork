package tree.model.familyTree;

import tree.model.human.Gender;
import java.util.Set;

public interface TreeItem<T> {
    String getName();
    T getFather();
    T getMother();
    Gender getGender();
    void setFather(T t);
    void setMother(T t);
    Set<T> getChildrenList();
    void setChildren(T human);
    String getChild();
}
