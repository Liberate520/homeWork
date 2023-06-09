package homeWork.tree2.backend.human;

import java.time.LocalDate;

public interface HumanObjectInterface<E> extends Comparable<E> {
    String getName();
    int getId();

    int getAge();
    LocalDate getBirthdate();
}
