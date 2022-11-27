package Tree2;

import java.util.ArrayList;
import java.util.List;

public class PersonTree {
    private final List<Person> tree = new ArrayList<>();

    public List<Person> getTree() {
        return tree;
    }

    public void add(Person person){
        tree.add(person);
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        for (Person el:tree){
            str.append(el.toString()).append("\n");
        }
        return str.toString();
    }
}