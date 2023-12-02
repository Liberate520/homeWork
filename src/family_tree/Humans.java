package family_tree;


import java.time.LocalDate;

public interface Humans<T extends Human> {

    String getName();
    LocalDate getBirthDate();

}
