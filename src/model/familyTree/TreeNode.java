package model.familyTree;

import java.time.LocalDate;

public interface TreeNode<T> {
    LocalDate getDateBirth();
    LocalDate getDateDeath();
    String getName();
    String getSurname();
    String getPatronymic();
    String briefName();
}
