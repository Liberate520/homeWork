import java.util.ArrayList;
import java.util.List;

public class FamilyTree {
    private List<Human> allHumans;

    public FamilyTree() {
        this.allHumans = new ArrayList<>();
    }

    public FamilyTree(List<Human> allHumans) {
        this.allHumans = allHumans;
    }

    public void addHuman(Human human) {
        if (!allHumans.contains(human)){
            allHumans.add(human);
            if (human.getFather() != null){
                human.getFather().addChild(human);
            }
            if (human.getMother() != null){
                human.getMother().addChild(human);
            }
        }
    }
}
