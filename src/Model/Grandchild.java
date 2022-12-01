package Model;

import java.util.List;

public class Grandchild extends Human {
    public List<Grandparent> grandparents;

    public Grandchild(boolean sex, int age, String firstName, String lastName) {
        super(sex, age, firstName, lastName);
    }
}
