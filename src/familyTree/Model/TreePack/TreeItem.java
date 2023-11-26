package familyTree.Model.TreePack;

import java.time.LocalDate;
import java.util.ArrayList;

public interface TreeItem<T> {

    void addParent(T parent);

    void addChild(T child);

   ArrayList<T> getChildren();
    LocalDate getBirthDate();
}

