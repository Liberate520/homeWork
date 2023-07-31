package genealogy_tree.Tree;

import genealogy_tree.Human.Gender;


import java.time.LocalDate;
import java.util.List;

public interface GeneologiTreeItem<E> {
    String getName();

    int getAge();

    long getId();

    E getSpouse();

    boolean addChild(E child);

    boolean addParents(E parent);

    E getFather();

    E getMother();

    int getLife(LocalDate birthDate, LocalDate deathDate);

    void setSpouse(E spouse);

    void setId(long id);

    LocalDate getBirthDate();

    LocalDate getDeathDate();

    List<E> getParents();

    List<E> getChildren();

    void setBirthDate(LocalDate birthDate);

    void setDeathDate(LocalDate deathDate);

    Gender getGender();

    String getInfo();

    String getFatherInfo();

    String getChildrenInfo();
}
