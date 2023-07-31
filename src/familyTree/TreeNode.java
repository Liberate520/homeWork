package familyTree;

import java.time.LocalDate;

public interface TreeNode<T> {
    LocalDate getDateBirth();
    String getName();
    String getSurname();
    String getPatronymic();
    String briefName();
}
