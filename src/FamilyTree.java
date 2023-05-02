import java.io.Serializable;
import java.util.ArrayList;

import java.util.Iterator;
import java.util.List;

public class FamilyTree<E extends HumanGroupItem> implements Serializable, Iterable<E> {
   // private HashSet<Human> familyTree;
    private List<E> familyTree;
    // public FamilyTree(HashSet<Human> familyTree) {
    //     this.familyTree = familyTree;
    // }

    // public FamilyTree() {        
    //     this(new HashSet<>());
    // }

    public FamilyTree() {
        familyTree = new ArrayList<>();
    }

    public List<E> getFamilyTree() {
        return familyTree;
    }

    public void addHuman(E human) {
        familyTree.add(human);
        if (((Human) human).getMother() != null) {
            ((Human) human).getMother().addChildren((Human) human);
        }

        if (((Human) human).getFather() != null) {
            ((Human) human).getFather().addChildren((Human) human);
        }
    }

    

    public E getHumanByName(String name) {
        for (E human : familyTree) {
            if (human.getName().equals(name)) {
                return human;
            }
        }
        return null;
    }

    public String getInfo() {
        StringBuilder stringBuilder = new StringBuilder();
        for (E human : familyTree) {
            stringBuilder.append(human);
            stringBuilder.append("\n");

        }
        return stringBuilder.toString();
    }

    @Override
    public Iterator<E> iterator() {
        return new HumanIterator<>(familyTree);
    }

    // @Override
    // public Iterator<Human> iterator() {
    //     return familyTree.iterator();
    // }

    public void sortByName(){
        familyTree.sort(new HumanComporatorByName<>());
    }

    public void sortById(){
        familyTree.sort(new HumanComparatorById<>());
    }


  


}
