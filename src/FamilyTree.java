import java.util.ArrayList;
import java.util.List;

public class FamilyTree {
    // private int id;
    private List<Human> humansList;

    public FamilyTree() {
        humansList = new ArrayList<>();
    }

    public void addHuman(Human human) {
        humansList.add(human);
    }

    public Human getHumanByName(String name) {
        for (Human human : humansList) {
            if (human.getName().equals(name)) {
                return human;
            }
        }
        return null;
    }

    public String getInfo() {
        StringBuilder stringBuilder = new StringBuilder();
        for (Human human : humansList) {
            stringBuilder.append(human);
            stringBuilder.append("\n");
        }
        return stringBuilder.toString();
    }
}
