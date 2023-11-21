package family_tree.model.family_tree;

import java.time.LocalDate;

public interface FamilyTreeHub<T> {
    String getLastName();

    String getFirstName();

    void setId(double id);

    double setId();

    double getIncome();

    String getPosition();

    int getAge();

    LocalDate getBirthDate();
}
