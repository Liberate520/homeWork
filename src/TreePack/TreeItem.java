package TreePack;

import PersonPack.Person;

import java.time.LocalDate;
import java.util.ArrayList;

public interface TreeItem<T> {

    void setParent1(T parent1);

    void setParent2(T parent2);

    void addChild(T child);

   ArrayList<T> getChildren();
    LocalDate getBirthDate();
}

