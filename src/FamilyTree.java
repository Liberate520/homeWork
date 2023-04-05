import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

public class FamilyTree implements Serializable {
    private Set<Human> family;

    public FamilyTree(HashSet<Human> family) {
        this.family = family;
    }

    public FamilyTree() {
        this(new HashSet<>());
    }
    public void addHuman(Human human){
        family.add(human);
        if (human.getFather() != null){
            human.getFather().addChild(human);
        }
        if (human.getMother() != null){
            human.getMother().addChild(human);
        }
    }

    public Human getByName(String firstName, String lastName){
        for (Human human: family) {
            if (human.getFirstName().equals(firstName) && human.getLastName().equals(lastName)){
                return human;
            }
        }
        return null;
    }
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Human human: family){
            sb.append(human.toString()).append("\n");
        }
        return "В родословной: " + family.size() + " человека, а именно: " + "\n" + sb.toString();
    }
}
