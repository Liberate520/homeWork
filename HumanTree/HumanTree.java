import java.util.ArrayList;
import java.util.List;

public class HumanTree {
    private List<Human> humanList;

    public HumanTree(List<Human> humanList) {
        this.humanList = humanList;
    }

    public HumanTree() {
        this(new ArrayList<>());
    }

    public List<Human> getHumanList() {
        return humanList;
    }

    public void setHumanList(List<Human> humanList) {
        this.humanList = humanList;
    }

    public void addHuman(Human human) {
        humanList.add(human);
    }
}
