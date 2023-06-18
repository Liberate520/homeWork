package FamilyTree.model.familyTree;

import java.time.LocalDate;
import java.util.ArrayList;

public interface TreeItem<T extends TreeItem> {
    boolean addChild(T human);

    T getFather();

    T getMother();

    String getName();
    String getInfo();
    LocalDate getDeathDate();
    LocalDate getBirthDate();
    ArrayList<T> getChildrens();
}
