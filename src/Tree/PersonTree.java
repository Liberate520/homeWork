package Tree;

import java.util.ArrayList;
import java.util.List;

public class PersonTree {
  
    private final List<Human> tree = new ArrayList<>();

    public List<Human> getTree() {
        return tree;
    }

    public void add(Human person){
        tree.add(person);
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        for (Human el:tree){
            str.append(el.toString()).append("\n");
        }
        return str.toString();
    }
}
