package family_tree.model.tree;

import family_tree.model.human.Position;

import java.time.LocalDate;

public interface TreeNode<T> {

    String getLastName();

    String getFirstName();

    void setId(double id);

    int setId();

    double getIncome();

    Position getPosition(T human);

    int getAge();

    LocalDate getBirthDate();



}