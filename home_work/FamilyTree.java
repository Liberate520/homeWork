package home_work;

import java.util.ArrayList;
import java.util.List;

public class FamilyTree {
    private List<Human> humanList = new ArrayList<>();

    public void createTree(Human human) {
        if (!humanList.contains(human)) humanList.add(human);
        if (!human.getChildrens().isEmpty()) {
            for (Human child : human.getChildrens()) {
                createTree(child);
            }
        }
    }

    public String getTree() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Family tree: \n");
        for (Human human : humanList) {
            if (!human.getChildrens().isEmpty()) {
                stringBuilder.append(human.getName() + " childrens: " + human.getChildrensName() + "\n");
            }
        }
        return stringBuilder.toString();
    }
}
