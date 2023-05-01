import java.io.Serializable;
import java.util.ArrayList;

import java.util.Iterator;
import java.util.List;

public class FamilyTree<E extends HumanGroupItem> implements Serializable, Iterable<Human> {
   // private HashSet<Human> familyTree;
    private List<Human> familyTree;
    // public FamilyTree(HashSet<Human> familyTree) {
    //     this.familyTree = familyTree;
    // }

    // public FamilyTree() {        
    //     this(new HashSet<>());
    // }

    public FamilyTree() {
        familyTree = new ArrayList<>();
    }

    public List<Human> getFamilyTree() {
        return familyTree;
    }

    public void addHuman(Human human) {
        familyTree.add(human);
        if (human.getMother() != null) {
            human.getMother().addChildren(human);
        }

        if (human.getFather() != null) {
            human.getFather().addChildren(human);
        }
    }

    

    public Human getHumanByName(String name) {
        for (Human human : familyTree) {
            if (human.getName().equals(name)) {
                return human;
            }
        }
        return null;
    }

    public String getInfo() {
        StringBuilder stringBuilder = new StringBuilder();
        for (Human human : familyTree) {
            stringBuilder.append(human);
            stringBuilder.append("\n");

        }
        return stringBuilder.toString();
    }

    @Override
    public Iterator<Human> iterator() {
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
