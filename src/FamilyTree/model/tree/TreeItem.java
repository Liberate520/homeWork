package FamilyTree.model.tree;

import java.time.LocalDate;
import java.util.List;

public interface TreeItem<T> {
    String getName();
    LocalDate getDateOfBirth();

    T getMother();

    T getFather();

    String getPersonInfo();
    boolean addChild(T person);

}
