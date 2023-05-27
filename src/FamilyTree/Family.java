package FamilyTree;

import java.util.ArrayList;
import java.util.List;

public class Family {
    List<Human> family;
    String familyName;

    public Family(String familyName) {
        family = new ArrayList<>();
        this.familyName = familyName;
    }

    public void setFamily(Human... human) {
        for (Human someHuman : human)
            family.add(someHuman);
    }

    @Override
    public String toString() {
        StringBuilder st = new StringBuilder();
        for (Human human : family)
            st.append(", " + human.name);
        return familyName + ": (" + st.toString().substring(2) + ")";
    }
}
