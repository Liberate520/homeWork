import java.util.ArrayList;
import java.util.List;
import java.io.Serializable;

public class FamilyTree implements Serializable {
    private List<Human> family = new ArrayList<>();

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