package home_work;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import java.util.Iterator;

public class FamilyTree<E extends AnimalItem> implements Serializable, Iterable<E>{
    private List<E> humanList;
    private List<E> childrens;

    public FamilyTree() {
        humanList = new ArrayList<>();
        childrens = new ArrayList<>();
    }

    public void createTree(E human) {
        childrens = human.getChildrens();
        if (!humanList.contains(human)) humanList.add(human);
        if (!human.getChildrens().isEmpty()) {
            for (E child : childrens) {
                createTree(child);
            }
        }
    }

    public Iterator<E> iterator() {
        return new HumanIterator(humanList);
    }

    public void sortByName() {
        humanList.sort(new HumanComparatorByName());
    }

    public void sortByAge() {
        humanList.sort(new HumanComparatorByAge());
    }

    // public String getTree() {
    //     StringBuilder stringBuilder = new StringBuilder();
    //     stringBuilder.append("Family tree: \n");
    //     for (Human human : humanList) {
    //         if (!human.getChildrens().isEmpty()) {
    //             stringBuilder.append(human.getName() + " childrens: " + human.getChildrensName() + "\n");
    //         }
    //     }
    //     return stringBuilder.toString();
    // }
}
