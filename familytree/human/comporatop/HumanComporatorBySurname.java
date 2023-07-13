package familytree.human.comporatop;
import java.util.Comparator;

import familytree.family_tree.FamilyTreeItem;
import familytree.human.Human;

public class HumanComporatorBySurname<P extends FamilyTreeItem> implements Comparator<P>{
    @Override
    public int compare(P o1, P o2){
        return o1.getSurname().compareTo(o2.getSurname());

    }
}
