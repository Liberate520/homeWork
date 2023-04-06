package tree.interfaces;

import java.time.LocalDate;
import java.util.Set;

public interface AlliService<E> {
    Set<E> getChildren();

    Set<E> getParents();

    String getFirstName();

    String getLastName();

    LocalDate getDateBirth();

}
