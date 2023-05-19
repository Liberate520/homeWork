package module.familystructure;

import module.familystructure.familycomparator.FamilyComparatorByChildren;
import module.familystructure.familycomparator.FamilyComparatorByName;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
public class FamilyTree<E extends FamilyGroup<E>> implements Serializable, Iterable<E>{
    private final List<E> humans;

    public FamilyTree() {
        this(new ArrayList<>());
    }

    public FamilyTree(List<E> humans) {
        this.humans = humans;
    }

    public void addHuman(E human) {
        if (human == null) {
            return;
        };
        if (!humans.contains(human)){
            humans.add(human);
            if (human.getFather() != null){
                human.getFather().addChild(human);
            }
            if (human.getMother() != null){
                human.getMother().addChild(human);
            }
        }
    }
    public void printTree(E human) {
        System.out.println("Person: " + human.toString());
        var children = human.getChildren();
        if (children.size() != 0) {
            for (Object child : children) {
                System.out.println("  " + "Дети:" + " " + child);
            }
        } else {
            System.out.println(" Дети: Нет детей");
        }

    }

    public List<E> getHumans() {
        return humans;
    }
    public void sortByName(){
        humans.sort(new FamilyComparatorByName<E>());
    }

    public void sortByChild(){
        humans.sort(new FamilyComparatorByChildren<E>());
    }

    @Override
    public Iterator<E> iterator() {
        return new FamilyIterator<E>(humans);
    }
}

