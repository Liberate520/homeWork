package homeWork.src;

import java.util.List;

public interface GenealogicalTree {
    void addParent(Human parent, Human child);
    void addSibling(Human sibling1, Human sibling2);
    List<Human> getChildren(Human parent);
}

