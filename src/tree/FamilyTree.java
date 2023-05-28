package tree;

import java.util.ArrayList;
import java.util.List;

public class FamilyTree {
    private List<Human> familyTree;
    private String familyName;

    public FamilyTree(String familyName) {
        familyTree = new ArrayList<>();
        this.familyName = familyName;
    }

    public void setFamily(List<Human> human) {
        for (Human someHuman : human) {
            familyTree.add(someHuman);
        }
    }

    public void setFamily(Human human) {
        familyTree.add(human);
    }

    public void outFamily(Human human) {
        familyTree.remove(human);
    }

    @Override
    public String toString() {
        StringBuilder st = new StringBuilder();
        for (Human human : familyTree)
            st.append(", " + human.getName());
        return familyName + ": (" + st.toString().substring(2) + ")";
    }
}
