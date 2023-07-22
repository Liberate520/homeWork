package family_tree.tree;

import family_tree.human.Child_type;
import family_tree.human.Gender;
import family_tree.human.Human;
import family_tree.human.Parent_Type;

import java.time.LocalDate;
import java.util.HashMap;

public interface Entity<E> {
    int getId();

    void setId(int id);

    String getFullName();

    String getFirstName();

    String getSecondName();

    String getFathersName();

    Gender getGender();

    E getSpouse();

    Boolean isMarried();

    void setSpouse(E spouse);

    void setSpouse(Human spouse);

    void removeSpouse();

    LocalDate getDateOfBirth();

    void setDateOfDeath(LocalDate dateOfDeath);

    LocalDate getDateOfDeath();

    int getAge(LocalDate dateOfBirth, LocalDate dateOfDeath);

    public HashMap<E, Parent_Type> getParents();

    public HashMap<E, Child_type> getChildren();

}
