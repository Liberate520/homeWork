package Family_Tree.Tree;

import Family_Tree.Human.Human;

import java.util.Comparator;

public class FamilyTreeComparatorByName implements Comparator<Human> {
    @Override
    public int compare(Human o1, Human o2){
        return o1.getName().compareTo(o2.getName());
    }
}
