package family_tree.familyTree;

import java.time.LocalDate;

public interface TreeItem<E> {
    String getName();
    LocalDate getBirthDate();
    void setDeathDate(LocalDate deathDate);
    void addChildren(E child);
    E getMother();
    E getFather();
    void addParents(E parent1, E parent2);
    void createRelatings(E parent1, E parent2, E child);
    String getAllChildrens();
    int getAge();
    String toString();
    boolean equals(Object obj);
}
