package family_tree.base;

import family_tree.human.Position;

import java.time.LocalDate;

public interface TreeNode<T> {

    String getLastName();

    String getFirstName();

    void setId(double id);

    double setId();

    double getIncome();

    Position getPosition(T human);

    int getAge();

    LocalDate getBirthDate();




}