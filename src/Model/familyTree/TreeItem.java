package Model.familyTree;

import java.time.LocalDate;

public interface TreeItem<E> {
    String getName();
    LocalDate getBirthDate();
    boolean setDeathDate(LocalDate deathDate);
    boolean addChildren(E child);
    E getMother();
    E getFather();
    boolean addParents(E parent1, E parent2);
    boolean createRelatings(E parent1, E parent2, E child);
    String getAllChildrens();
    int getAge();
    String toString();
    boolean equals(Object obj);
}
