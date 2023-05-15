import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
public class FamilyThree<E extends FamilyGroup> implements Serializable, Iterable<Human>{
    private List<E> humans;

    public FamilyThree() {
        this(new ArrayList<>());
    }

    public FamilyThree(List<E> humans) {
        this.humans = humans;
    }

    public void addHuman(E human) {
        if (human == null) {
            return;
        };
        if (!humans.contains(human)){
            humans.add(human);
            if (human.getFather() != null){
                human.getFather().addChild((Human)human);
            }
            if (human.getMother() != null){
                human.getMother().addChild((Human)human);
            }
        }
    }
    public void printTree(Human human) {
        System.out.println("Person: " + human.toString());
        List<Human> children = human.getChildren();
        if (children.size() != 0) {
            for (Human child : children) {
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
        humans.sort(new FamilyComparatorByChildrens<E>());
    }

    @Override
    public Iterator<Human> iterator() {
        return (Iterator<Human>) new FamilyIterator<E>(humans);
    }
}

