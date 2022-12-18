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

    public List<Human> getHumanList() {
        return humanList;
    }

    public void addHuman(Human human){
        humanList.add(human);
    }

    @Override
    public String toString() {
        String s = "";
        for (Human human: humanList) {
            s += human + "\n";
        }
        return s;
    }

    public Human getHumanByName(String name){
        for (Human human: humanList){
            if (human.getName().equals(name)){
                return human;
            }
        }
        return null;
    }
}
