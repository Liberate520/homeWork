package famyilyTree;

import human.Human;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class FamilyTree implements Serializable {
    private List<Human> humanList;
    public FamilyTree() { this(new ArrayList<>()); }
    public FamilyTree(List<Human> humanList) {
        this.humanList = humanList;
    }

//    public FamilyTree() {
//        this.familyTree = new ArrayList<>();
//    }

    public boolean add(Human human){
        if (human == null) {
            return false;
        }
        if (!humanList.contains(human)) {
            humanList.add(human);
            if (human.getFather() != null) {
                human.getFather().addChild(human);
            }
            if (human.getMother() != null) {
                human.getMother().addChild(human);
            }
            return true;
        }
        return false;
    }

    public Human getByName(String name) {
        for (Human human: humanList) {
            if (human.getname().equals(name)) {
                return human;
            }
        }
        return null;
    }

    public String getInfo() {
        StringBuilder sb = new StringBuilder();
        sb.append("В дереве ");
        sb.append(humanList.size());
        sb.append(" объектов \n");
        for (Human human: humanList) {
            sb.append(human.getInfo());
            sb.append("\n");
        }
        return sb.toString();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) { return true; }
        if (!(obj instanceof FamilyTree)) { return false; }
        FamilyTree other = (FamilyTree) obj;
        return this.humanList.equals(other.humanList);
    }
}
