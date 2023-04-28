
import java.util.List;

public class FamilyTreeView {
    public void displayHuman(Human human) {
        System.out.println(human);
    }

    public void displayAllHumans(List<Human> humanList) {
        for (Human human : humanList) {
            System.out.println(human);
        }
    }
}
