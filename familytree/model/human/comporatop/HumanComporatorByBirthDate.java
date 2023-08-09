package familytree.model.human.comporatop;
import java.util.Comparator;

import familytree.model.family_tree.FamilyTreeItem;

public class HumanComporatorByBirthDate <P extends FamilyTreeItem>implements Comparator<P> {



    @Override
    public int compare(P o1, P o2){
        return o1.getDateOfBirth().compareTo(o2.getDateOfBirth());
    }

}
