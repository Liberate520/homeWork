package familytree.model.human.comporatop;
import java.util.Comparator;

import familytree.model.family_tree.FamilyTreeItem;
import familytree.model.human.Human;

public class HumanComporatorBySurname<P extends FamilyTreeItem> implements Comparator<P>{
    @Override
    public int compare(P o1, P o2){
        return o1.getSurname().compareTo(o2.getSurname());

    }
}
