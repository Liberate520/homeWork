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
    
    public List<Human> getChild(Human parent){
        List<Human> res = new ArrayList<>();
        for (Human human: humanList){
            if (human.getFather() == parent){
                res.add(human);
            }
        }
        return res;
    }

    public List<Human> getSistBroth(Human one){
        List<Human> res = new ArrayList<>();
        for (Human human: humanList){
            if (human.getFather() == one.getFather() && human.getName()!=one.getName()){
                res.add(human);
            }
        }
        return res;
    }
}
