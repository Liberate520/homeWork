package family_tree;

import java.util.List;
import java.util.ArrayList;

public class FamilyTree {
    private List<Human> humanList;

    public FamilyTree() {
        humanList = new ArrayList<>();
    }

    public void addHuman(Human human) {
        humanList.add(human);
    }

    public String getFamilyTree() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Список родственников:\n");
        for (Human human : humanList) {
            stringBuilder.append(human);
            stringBuilder.append("---------\n");
        }
        return stringBuilder.toString();
    }
}
