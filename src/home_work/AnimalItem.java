package home_work;

import java.time.LocalDate;
import java.util.List;

public interface AnimalItem<E> {
    List<E> getChildrens();
    LocalDate getDateOfBirth();
    String getName();
}
