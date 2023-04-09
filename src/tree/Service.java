package tree;

import tree.familyTree.FamilyTree;
import tree.essences.*;
import tree.essences.comparators.HumanComparatorByDateBirth;
import tree.essences.comparators.HumanComparatorByFirstName;
import tree.interfaces.Handler;

public class Service {
    private FamilyTree famTree;
    private Handler handler;

    public Service(FamilyTree famTree) {
        this.famTree = famTree;
    }

    public void printIn() {
        handler.printIn();
    }

    public void printOut() {
        handler.printOut();
    }

    public void addHuman(Human human) {
        famTree.addHuman(human);
    }

    public void sortByFirstName() {
        famTree.getPeopleList().sort(new HumanComparatorByFirstName());
    }

    public void SortByDateBirth() {
        famTree.getPeopleList().sort(new HumanComparatorByDateBirth());
    }
}
