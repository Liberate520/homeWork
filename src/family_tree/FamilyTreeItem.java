package family_tree;

import human.Human;

import java.time.LocalDate;
import java.util.List;

public interface FamilyTreeItem {
    boolean addChild(Human child);

    String getFirstName();

    String getLastName();

    LocalDate getBirthDate();

    LocalDate getDeathDate();

    Human getMother();

    Human getFather();

    List<Human> getChildren();

    String getInfo();
}
