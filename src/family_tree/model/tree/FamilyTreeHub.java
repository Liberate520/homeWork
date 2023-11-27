package family_tree.model.tree;

import java.time.LocalDate;

public interface FamilyTreeHub<T> {
    String getLastName();

//    String getFirstName();

//    void getId(double id);

    boolean setId();

    double getIncome();

    String getPosition();

    void getAge();

    LocalDate getBirthDate();
}
