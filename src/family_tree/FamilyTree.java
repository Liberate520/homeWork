package family_tree;

import java.util.List;
import java.io.Serializable;
import java.util.ArrayList;

public class FamilyTree implements Serializable {
    private List<Human> humanList;

    public FamilyTree() {
        humanList = new ArrayList<>();
    }

    public void createFamily(Human human1, Human human2, Human human3) {
        human3.createRelatings(human1, human2, human3);
        humanList.add(human1);
        humanList.add(human2);
        humanList.add(human3);
    }

    public void addHuman(Human human) {
        humanList.add(human);
    }

    public String getFamilyTree() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Семья:\n");
        for (Human human : humanList) {
            stringBuilder.append(human);
            stringBuilder.append("---------\n");
        }
        return stringBuilder.toString();
    }
}
