package Model.tree;

import java.util.Collections;

public class Service {
    public Service() {
    }

    public void sortByName(FamilyTree tree){
        Collections.sort(tree.getTreeElements(), new HumanComparatorByName());
    }

    public void sortByAge(FamilyTree tree){
        Collections.sort(tree.getTreeElements(), new HumanComparatorByAge());
    }
}
