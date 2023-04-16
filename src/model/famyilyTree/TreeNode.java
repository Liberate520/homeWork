package model.famyilyTree;

import java.time.LocalDate;

public interface TreeNode<T> {
    TreeNode getFather();
    TreeNode getMother();
    boolean addChild(T human);
    String getFirstName();
    String getLastName();
    String getInfo();
    LocalDate getDateBirth();
    LocalDate getDateDeath();

    int getId();
}
