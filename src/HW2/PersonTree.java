package HW2;

import java.util.ArrayList;
import java.util.List;

public class PersonTree {
    private List<Person> tree = new ArrayList<>();

    public List<Person> getTree() {
        return tree;
    }

    public void add(Person person){
        tree.add(person);
    }

    @Override
    public String toString() {
        String str = new String();
        for (Person el:tree){
            str+= el.toString()+"\n";
        }
        return str;
    }
}