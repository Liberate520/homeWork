package FamilyTree.Tree.HumanGroup;


import FamilyTree.Tree.Comparators.ComparatorDateOfBirth;
import FamilyTree.Tree.Comparators.ComparatorPatronymic;
import FamilyTree.Tree.Comparators.HumanComporatorByName;
import FamilyTree.Tree.HumanGroup.Human.Human;

import java.util.*;

public class HumanGroup extends Human implements Iterable<Human> {
    private List<Human> humanList;

    public HumanGroup() {
        humanList = new ArrayList<>();
    }


    public void addHuman(Human human) {
        humanList.add(human);
    }

    public void sortByName() {
        humanList.sort(new HumanComporatorByName());
    }
    public void sortPatronymic() {
        humanList.sort(new ComparatorPatronymic());
    }
    public void sortDateOfBirth() {
        humanList.sort(new ComparatorDateOfBirth());
    }
    @Override
    public Iterator<Human> iterator() {
        return new HumanIterator(humanList);
    }
}

