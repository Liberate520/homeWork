package family_tree;


import java.time.LocalDate;

public interface Humans<T> {

    String getName();
    LocalDate getBirthDate();

   boolean setFather(T father);
   boolean isInTree();
}
