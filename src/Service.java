import iterAndComp.HumanComparatorByName;
import tree.Family;

public class Service {
    private Family family;

    public Service(Family family) {
        this.family = family;
    }

    public void sortByName(){
       family.getMembers().sort(new HumanComparatorByName());
    }
}
