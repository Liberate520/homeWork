package FamilyTree.Tree.HumanGroup;


import FamilyTree.Tree.Comparators.ComparatorDateOfBirth;
import FamilyTree.Tree.Comparators.ComparatorPatronymic;
import FamilyTree.Tree.Comparators.HumanComparatorByName;
import FamilyTree.Tree.HumanGroup.Human.Human;


import java.io.Serializable;
import java.util.*;

public class HumanGroup <E extends HumanGroupItem> implements Iterable<E>, Serializable {
    private List<E> humanList;

    public HumanGroup() {
        humanList = new ArrayList<>();
    }


    public void addHuman(E human) {
        humanList.add(human);
    }

    public void sortByName() {
        humanList.sort(new HumanComparatorByName<>());
    }
    public void sortPatronymic() {
        humanList.sort(new ComparatorPatronymic<>());
    }
    public void sortDateOfBirth() {
        humanList.sort(new ComparatorDateOfBirth<>());
    }
    @Override
    public Iterator<E> iterator() {
        return new HumanIterator(humanList);
    }

}

