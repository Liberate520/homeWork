package model.HumanModel;

import java.time.LocalDate;
import java.util.List;

public interface HumanInterface<T> {
    long getId();

    void setId(long id);

    LocalDate getDeathDate();

    LocalDate getBirthDate();

    int getAge();

    Gender getGender();

    T getMather();

    T getFather();

    List<T> getChildren();

    void addChildren(T t);

    void setMather(T t);

    void setFather(T t);

    String getLastName();

    String getFirstName();

    Human getSelf();
}
