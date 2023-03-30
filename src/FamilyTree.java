import java.util.ArrayList;
import java.util.List;

public class FamilyTree {
    private List<Human> familyTree;

    public FamilyTree() {
        this.familyTree = new ArrayList<Human>();
    }

    public void addHuman(Human human) {
        this.familyTree.add(human);
        if (human.getMother() != null) {
            human.getMother().addChild(human);
        }
        if (human.getFather() != null) {
            human.getFather().addChild(human);
        }
    }

    @Override
    public String toString() {
        StringBuilder stb = new StringBuilder("Генеалогическое древо состоит из: \n");
        for (Human human : familyTree) {
            stb.append(human).append("\n");
        }
        return stb.toString();
    }

    public void printChildren() {
        for (Human humanTemp : familyTree) {
            if (humanTemp.getChildren().isEmpty()) {
                System.out.printf("%s (%d) не имеет детей!\n ", humanTemp.getFullName(), humanTemp.getBirthYear());
            } else {
                System.out.printf("%s (%d) имеет следующих детей:\n %s\n", humanTemp.getFullName(), humanTemp.getBirthYear(), humanTemp.getChildren());
            }
        }
    }
}
