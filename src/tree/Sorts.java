package tree;
import human.Human;
import tree.comparators.HumanComparebyBirthyear;
import tree.comparators.HumanComparebyChild;
import tree.comparators.HumanComparebyId;
import tree.comparators.HumanComparebyName;

public class Sorts<E extends Human> {
    private Tree<E> tree;

    public Sorts(Tree<E> tr) {
        this.tree = tr;
    }

    public void sortbyName() {
        tree.getPeople().sort(new HumanComparebyName<E>());
    }

    public void sortbyId() {
        tree.getPeople().sort(new HumanComparebyId<E>());
    }

    public void sortbyChild() {
        tree.getPeople().sort(new HumanComparebyChild<E>());
    }

    public void sortbyBirthyear() {
        tree.getPeople().sort(new HumanComparebyBirthyear<E>());
    }
}
