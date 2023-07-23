package GenerationTree.Model.Person.Comparators;

import java.util.Comparator;

import GenerationTree.Model.Person.Person;
import GenerationTree.Model.Tree.GenTreeItem;

public class PersonComparatorBySename implements Comparator<GenTreeItem> {

    @Override
    public int compare(GenTreeItem o1, GenTreeItem o2) {
        return ((Person) o1).getSurname().compareTo(((Person) o2).getSurname());
    }

}
