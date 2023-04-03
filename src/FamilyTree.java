import java.util.ArrayList;
import java.util.List;

public class FamilyTree {
    private List<Human> humanList;

    public FamilyTree(List<Human> humanList) {
        this.humanList = humanList;
    }

    public FamilyTree() {
        this(new ArrayList<>());
    }

    public void addHumanList(Human humanList) {
        this.humanList.add(humanList);
    }

    public void printHumanList() {
        System.out.println("Members of Family");
        for (Human humanList: this.humanList) {
            System.out.println(humanList.toString());
        }
    }

}