package FamilyTree.FamilyTree;

import Human.Human;

import java.time.LocalDate;
import java.util.List;

public interface EntityItem<T> {
    String getName();

    int getAge();

    T getSpouse();

    String getAgeToString();

    int getPeriod(LocalDate birthday, LocalDate deathDate);

    String getInfo();
}
