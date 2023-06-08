package tree.geneticTree;

import tree.human.Human;

import java.time.LocalDate;

public interface GroupItem {
    String getName();
    String getInfo();
    LocalDate getBirthDate();
    Human getFather();
    Human getMother();
}
