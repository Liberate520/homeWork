package Tree1;

import java.util.ArrayList;
import java.util.List;

public class PetTree {
    /**
     * Класс хранящий список животных. Имеет сеттер и геттер.
     */
    private final List<Pet> tree = new ArrayList<>();

    public List<Pet> getTree() {
        return tree;
    }

    public void add(Pet pet){
        tree.add(pet);
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        for (Pet el:tree){
            str.append(el.toString()).append("\n");
        }
        return str.toString();
    }
}
