package FamilyTree.Tree.model.HumanGroup;


import FamilyTree.Tree.model.Comparators.ComparatorDateOfBirth;
import FamilyTree.Tree.model.Comparators.ComparatorPatronymic;
import FamilyTree.Tree.model.Comparators.ComparatorReadSave;
import FamilyTree.Tree.model.Comparators.HumanComparatorByName;
import FamilyTree.Tree.model.HumanGroup.Human.Human;


import java.io.Serializable;
import java.util.*;

public class HumanGroup <E extends HumanGroupItem> implements Iterable<E>, Serializable {
    private static List<Human> humanList;

    public HumanGroup() {
        humanList = new ArrayList<>();
    }

    public HumanGroup(HumanGroup<Human> group, String name, String surname, String dateOfBirth) {
    }


    public static void addHuman(Human human) {
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

    public void readFam() {
        humanList.sort(new ComparatorReadSave<>());
    }


    public void addChildren(HumanGroup humanGroup) {

    }

    public void setFather(HumanGroup humanGroup) {
    }

    public void setMother(HumanGroup humanGroup) {
    }
}

