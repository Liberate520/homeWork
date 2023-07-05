package familyTree;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
public class FamilyTree implements Serializable {
    private int idHuman;
    private List<Human> humanList;



    public FamilyTree(List<Human> humanList) {
        this.humanList = humanList;
    }
    public FamilyTree() {
        this(new ArrayList<>());
    }

    public boolean add(Human human) {
        if (human == null) {
            return false;
        }
        if (!humanList.contains(human)) {
            humanList.add(human);
            addToParents(human);
            addToChildren(human);
            human.setId(idHuman++);
            return true;
        }
        return false;
    }
    public void addToParents(Human human) {
        for (Human parent: human.getParents()) {
            parent.addChild(human);
        }
    }
    public void addToChildren(Human human) {
        for (Human child: human.getChildren()) {
            child.addParent(human);
        }
    }

    public Human getByName(String name) {
        for (Human human: humanList) {
            if (human.getName().equalsIgnoreCase(name)){
                return human;
            }
        }
        return null;
    }

    public String getInfo() {
        StringBuilder sb = new StringBuilder();
        sb.append("В дереве ");
        sb.append(humanList.size());
        sb.append(" человека: \n");
        for (Human human: humanList) {
            sb.append(human);
            sb.append("\n");
        }
        return sb.toString();
    }

    @Override
    public String toString() {
        return getInfo();
    }
}
