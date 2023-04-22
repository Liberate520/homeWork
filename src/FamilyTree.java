import java.util.ArrayList;
import java.util.List;

public class FamilyTree {
    private List<Human> humans;

    public FamilyTree() {
        this.humans = new ArrayList<>();
    }

    public void addHuman(Human human) {
        if (!this.humans.contains(human)) {
            this.humans.add(human);
        }
    }

    public String getFamilyInfo() {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < humans.size(); i++) {
            stringBuilder.append(i + 1 + " ");
            stringBuilder.append(humans.get(i).getGeneralInfo());
            stringBuilder.append("\n");
        }
        return stringBuilder.toString();
    }

}
