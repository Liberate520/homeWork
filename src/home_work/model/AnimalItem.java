package home_work.model;

import java.time.LocalDate;
import java.util.List;

public interface AnimalItem<E> {
    List<E> getChildrens();
    LocalDate getDateOfBirth();
    String getName();
    List<E> getChildrensName();
}
