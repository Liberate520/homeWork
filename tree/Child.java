package homeWork.tree;

import java.time.LocalDate;
import java.util.ArrayList;

public class Child extends Human {

    private ArrayList<Human> parents;

    public Child(String name, String gender, LocalDate birthday, Boolean alive, Boolean childfree) {
        super(name, gender, birthday, alive, childfree);
        parents = new ArrayList<>();
    }

    public void addParent(Human human) {
        this.parents.add(human);
    }


    @Override
    public String toString() {
        return this.getName() + " " + parents;
    }

    public ArrayList<Human> getParents() {
        return parents;
    }
}
