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

    public void SortbyName() {
        tree.getPeople().sort(new HumanComparebyName<E>());
    }

    public void SortbyId() {
        tree.getPeople().sort(new HumanComparebyId<E>());
    }

    public void SortbyChild() {
        tree.getPeople().sort(new HumanComparebyChild<E>());
    }

    public void SortbyBirthyear() {
        tree.getPeople().sort(new HumanComparebyBirthyear<E>());
    }
}
