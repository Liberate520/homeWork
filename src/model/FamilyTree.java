package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class FamilyTree<E extends GroupItem> implements Serializable, Iterable<E>{
    private List<E> familyTreeList = new ArrayList<>();

    public void addHuman(E human){
        familyTreeList.add(human);
    }

    public void setParent(int idChild, int idParent) {
        for (E humanChild: familyTreeList){
            if (humanChild.getId() == idChild){
                for (E humanParent: familyTreeList){
                    if (humanParent.getId() == idParent){
                        humanChild.setParent((Human) humanParent);
                    }
                }
            }
        }
    }
    public void sortByName(){
        familyTreeList.sort(new TreeComparatorByName<>());
    }

    public void sortByBirthDay(){
        familyTreeList.sort(new TreeComparatorByBirthDay<>());
    }

    @Override
    public Iterator<E> iterator() {
        return new HumanIterator<>(familyTreeList);
    }
}
