package family_tree;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;


public class FamilyTree implements Serializable {
    private List<Human> humans = new LinkedList<Human>();

    public void addHuman(Human human) {
       this.humans.add(human);
    }

    public List<Human> getHumans() {
        return this.humans;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (Human human: this.humans) {
            stringBuilder.append(this.humans.indexOf(human)+1);
            stringBuilder.append(") ");
            stringBuilder.append(human.toString());
            stringBuilder.append("\n");
        }
        return stringBuilder.toString();
    }
}
