package familytree.human.comporatop;
import familytree.family_tree.FamilyTreeItem;
import familytree.human.Human;
import java.util.Comparator;

public class HumanComporatorByBirthDate <P extends FamilyTreeItem>implements Comparator<P> {



    @Override
    public int compare(P o1, P o2){
        return o1. getDateOfBirth().compareTo(o2. getDateOfBirth());
    }

}
