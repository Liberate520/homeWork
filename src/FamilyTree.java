import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class FamilyTree implements Serializable {
    private List<Human> humanList;

    public FamilyTree() { this(new ArrayList<>()); }

    public FamilyTree(List<Human> humanList) { this.humanList = humanList; }

    public boolean add(Human human){
        if (human == null){
            return false;
        }
        if (!humanList.contains(human)){
            humanList.add(human);
            if (human.getFather() != null){
                human.getFather().addChild(human);
            }
            if (human.getMother() != null){
                human.getMother().addChild(human);
            }
            return true;
        }
        return false;
    }

    public Human getByName(String name){
        for (Human human : humanList){
            if (human.getName().equals(name)){
                return human;
            }
        }
        return null;
    }

    public String getInfo(){
        StringBuilder res = new StringBuilder();
        res.append(humanList.size());
        res.append(" objects in the tree: \n");
        for (Human human : humanList){
            res.append(human.getInfo());
            res.append("\n");
        }
        return res.toString();
    }
}
