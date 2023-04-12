import java.io.Serializable;
import java.util.*;

public class FamilyTree<E extends Human> implements Serializable, Iterable<E> {
    private List<E> family;

    public FamilyTree(ArrayList<E> family) {
        this.family = family;
    }

    public FamilyTree() {
        this(new ArrayList<>());
    }

    public List<E> getHumanList() {
        return family;
    }
    public void addHuman(E human){
        if(!family.contains(human)){
            family.add(human);
        }
        if (human.getFather() != null){
            human.getFather().addChild(human);
        }
        if (human.getMother() != null){
            human.getMother().addChild(human);
        }
    }

    public void removeHuman(E human) {
        if (human.getMother() != null){
            human.getMother().getChildren().remove(human);
        }
        if (human.getFather() != null) {
            human.getFather().getChildren().remove(human);
        }
        family.remove(human);
    }

    public E getByName(String firstName, String lastName){
        for (E human: family) {
            if (human.getFirstName().equals(firstName) && human.getLastName().equals(lastName)){
                return human;
            }
        }
        return null;
    }
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (E human: family){
            sb.append(human.toString()).append("\n");
        }
        return "В родословной: " + family.size() + " человека, а именно: " + "\n" + sb.toString();
    }

    @Override
    public Iterator<E> iterator() {
        return new HumanIterator<>(family);
    }
}
