package HW2;

import java.util.ArrayList;
import java.util.List;

public class PetTree<T> {
    /**
     * Класс хранящий список животных. Имеет сеттер и геттер.
     */
    private final List<T> tree = new ArrayList<>();

    public List<T> getTree() {
        return tree;
    }

    public void add(T pet){
        tree.add(pet);
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        for (T el:tree){
            str.append(el.toString()).append("\n");
        }
        return str.toString();
    }
}