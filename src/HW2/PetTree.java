package HW2;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class PetTree {
    private List<Pet> tree = new ArrayList<>();

    public List<Pet> getTree() {
        return tree;
    }

    public void add(Pet pet){
        tree.add(pet);
    }

    @Override
    public String toString() {
        String str = new String();
        for (Pet el:tree){
            str+= el.toString()+"\n";
        }
        return str;
    }
}
