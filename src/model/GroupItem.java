package model;

import java.time.LocalDate;

public interface GroupItem<E> {
    String getName();
    LocalDate getBirthday();

    String allInfo();

    Integer getId();

    void setParent(Human human);
}
