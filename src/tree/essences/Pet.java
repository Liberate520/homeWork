package tree.essences;

import java.time.LocalDate;
import java.util.HashSet;

public class Pet extends Human {

    public Pet(String firstName, String lastName, Gender gender, LocalDate dateBirth, LocalDate dateDeath) {
        super(firstName, lastName, gender, dateBirth, dateDeath);
        super.parents = new HashSet<Human>();
        super.children = new HashSet<Human>();
    }

    public Pet(String firstName, String lastName, Gender gender, LocalDate dateBirth) {
        super(firstName, lastName, gender, dateBirth);
        super.parents = new HashSet<Human>();
        super.children = new HashSet<Human>();
    }

}
