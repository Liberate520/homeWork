package model.tree;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import model.human.Human;
import model.human.comporatos.HumanComparatorById;
import model.human.comporatos.HumanComporatorByName;

public class FamilyTree<E extends HumanGroupItem> implements Serializable, Iterable<E> {

    private List<E> familyTree;
   
    public FamilyTree() {        
        this(new ArrayList<>());
    }

    public FamilyTree(List<E> familyTree) {
        this.familyTree = familyTree;
    }

    public List<E> getFamilyTree() {
        return familyTree;
    }

    public boolean addHuman(E human) {
        if (human == null) {
            return false;
        }
        if (!familyTree.contains(human)) {
            familyTree.add(human);
            if (human.getMother() != null) {
                human.getMother().addChildren((Human) human);
            }

            if (human.getFather() != null) {
                human.getFather().addChildren((Human) human);
            }
            return true;
        }
        return false;
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

    public void sortByName() {
        familyTree.sort(new HumanComporatorByName<>());
    }

    public void sortById() {
        familyTree.sort(new HumanComparatorById<>());
    }

    



}
