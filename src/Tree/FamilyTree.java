package Tree;

import java.util.ArrayList;
import java.util.List;

public class FamilyTree {
    List<Human> family;
    String familyName;

    public FamilyTree(String familyName) {
        family = new ArrayList<>();
        this.familyName = familyName;
    }

    public void setFamily(Human... human) {

        for (Human someHuman : human) {
            family.add(someHuman);
        }
    }

    public void outFamily(Human human) {
        family.remove(human);
    }

    @Override
    public String toString() {
        StringBuilder st = new StringBuilder();
        for (Human human : family)
            st.append(", " + human.name);
        return familyName + ": (" + st.toString().substring(2) + ")";
    }
}
