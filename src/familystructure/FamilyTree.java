package familystructure;

import familystructure.familycomparator.FamilyComparatorByChildrens;
import familystructure.familycomparator.FamilyComparatorByName;
import familystructure.familycomparator.FamilyGroup;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
public class FamilyTree<E extends FamilyGroup<E>> implements Serializable, Iterable<E>{
    private List<E> humans;

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
        humans.sort(new FamilyComparatorByName<>());
    }

    public void sortByChild(){
        humans.sort(new FamilyComparatorByChildrens<>());
    }

    @Override
    public Iterator<E> iterator() {
        return new FamilyIterator<>(humans);
    }
}

