package familyTree;

import obj.Gender;

import java.time.LocalDate;
import java.util.List;

public interface FamilyTreeItem<E> {
    long getId();

    void setId(long id);

    String getFstName();

    void setFstName(String fstName);

    String getLstName();

    void setLstName(String lstName);

    void addChild(E child);

    List<E> getChildrens();

    void setChildrens(List<E> childrens);

    void addParent(E parent);

    E getMother();

    void setMother(E mother);

    E getFather();

    void setFather(E father);

    Gender getGender();

    LocalDate getBornDate();

    void setBornDate(LocalDate bornDate);

    LocalDate getDeathDate();

    void setDeathDate(LocalDate deathDate);

    void setGender(Gender gender);

    public int getAge();

}
