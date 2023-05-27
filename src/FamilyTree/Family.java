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

    public void setFamily(Human human) {
        family.add(human);
    }
    public void setFamily(Human human1, Human human2) {
        family.add(human1);
        setFamily(human2);
    }
    public void setFamily(Human human1, Human human2, Human human3) {
        family.add(human1);
        setFamily(human2, human3);
    }


    @Override
    public String toString() {
        StringBuilder st = new StringBuilder();
        for (Human human : family)
            st.append(", " + human.name);
        return familyName + ": (" + st.toString().substring(2, st.length()) + ")";
    }
}
