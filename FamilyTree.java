import java.util.ArrayList;
import java.util.List;

public class FamilyTree {
    List<Human> family = new ArrayList<>();

    public void printFamily() {
        System.out.println("Члены семьи");
        for (Human human : family) {
            System.out.println(human + "\n");
        }
    }

    public void addHuman(Human human) {
        family.add(human);
    }
}