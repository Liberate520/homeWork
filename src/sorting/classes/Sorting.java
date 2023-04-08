package sorting.classes;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import tree.classes.Human;
import tree.interfaces.iTree;

public class Sorting {
    private List<Human> persons = new ArrayList<>();
    private iTree tree;

    public Sorting(iTree tree)
    {
        this.tree = tree;
    }

    public void sortByName(){
        persons = tree.getTree();
        Collections.sort(persons, new HumanComparatorByName());
    }

    public void sortByBirthDate(){
        persons = tree.getTree();
        Collections.sort(persons, new HumanComparatorByBirth());
    }

}
