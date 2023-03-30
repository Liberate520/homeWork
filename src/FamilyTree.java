import java.util.ArrayList;
import java.util.Map;

public class FamilyTree {
    private Human human;

    public FamilyTree(Human human) {
        this.human = human;
    }

    public void getRelatives() {
        System.out.println("All relatives for: " + human.getFullName());
        if (!human.getFamily().isEmpty()) {
            for (Map.Entry<Relationship, ArrayList<Human>> entry :
                    human.getFamily().entrySet()) {
                System.out.print("\t");
                System.out.print(entry.getKey() + ": ");
                for (Human human : entry.getValue()) {
                    System.out.print(human.getFullName()+"; ");
                }
                System.out.println();
            }
        } else System.out.println("\tNo registered relatives");
    }
}
