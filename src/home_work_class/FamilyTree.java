package home_work_class;

import java.util.ArrayList;
import java.util.List;

public class FamilyTree {
    private List<Human> humansList;

    public FamilyTree() {
        humansList = new ArrayList<>();
    }

    public String showHumansList(){
        StringBuilder stringBuilder = new StringBuilder();
        for (Human human: humansList) {
            stringBuilder.append(human);
            stringBuilder.append("\n");
        }
        return stringBuilder.toString();
    }

    public void addHuman(Human human){
        humansList.add(human);
    }
}
