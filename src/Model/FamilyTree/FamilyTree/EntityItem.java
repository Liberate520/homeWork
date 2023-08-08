package Model.FamilyTree.FamilyTree;

import java.time.LocalDate;

public interface EntityItem<T> {
    String getName();

    int getAge();

    T getSpouse();

    String getAgeToString();

    int getPeriod(LocalDate birthday, LocalDate deathDate);

    String getInfo();

    void setSpouse(T entity);

    void setDeathDate(LocalDate deathDate);
}
