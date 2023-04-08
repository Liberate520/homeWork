import java.util.ArrayList;
import java.util.List;

public class FamilyTree {
    private List<Human> family;

    public FamilyTree() {
        this(new ArrayList<>());
    }

    public FamilyTree(ArrayList family) {
        this.family = family;
    }

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
