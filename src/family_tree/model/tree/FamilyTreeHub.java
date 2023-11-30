package family_tree.model.tree;

import family_tree.model.human.Position;

import java.time.LocalDate;

public interface FamilyTreeHub {
    String getLastName();

//    String getFirstName();

//    void getId(double id);

    boolean setId();

    double getIncome();

    Position getPosition();

    void getAge();

    LocalDate getBirthDate();
}
