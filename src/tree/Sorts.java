package tree;
import tree.comparators.HumanComparebyBirthyear;
import tree.comparators.HumanComparebyChild;
import tree.comparators.HumanComparebyId;
import tree.comparators.HumanComparebyName;

public class Sorts {
    private Tree tree;

    public Sorts(Tree tr) {
        this.tree = tr;
    }

    public void SortbyName() {
        tree.getPeople().sort(new HumanComparebyName());
    }

    public void SortbyId() {
        tree.getPeople().sort(new HumanComparebyId());
    }

    public void SortbyChild() {
        tree.getPeople().sort(new HumanComparebyChild());
    }

    public void SortbyBirthyear() {
        tree.getPeople().sort(new HumanComparebyBirthyear());
    }
}
