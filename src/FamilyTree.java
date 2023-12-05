import java.util.ArrayList;
import java.util.List;

public class FamilyTree {
    private List<Human> humanList;

    public FamilyTree(){
        humanList = new ArrayList<>();
    }

    public FamilyTree(List<Human> humanList){
        this.humanList = humanList;
    }

    public static void addHuman(Human human){
        humanList.add(human);
    }
}
