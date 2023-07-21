package homeWork.tree2.backend.human;

import java.time.LocalDate;

public interface HumanObjectInterface<E> extends Comparable<E> {
    String getName();
    int getId();

    int getAge();
    LocalDate getBirthdate();
}

// Возможно, заходим за черту 4 принципа, но тут все достаточно просто, и, кажется, декомпозиция тут - перебор
