package HW_1;
import java.util.ArrayList;
import java.util.List;

public class FamilyTree {
    List<Human> humanList;

    public FamilyTree(List<Human> humanList) {
        this.humanList = humanList;
    }

    public FamilyTree() {
        this(new ArrayList<>());
    }

    @Override
    public String toString() {
        return "" + humanList ;
    }
}
