package family_tree;

import java.util.ArrayList;
import java.util.List;

public class FamilyTree {
    private long humansId;
    private List<Human> humanList;


    public FamilyTree() { this(new ArrayList<>()); }

    public  FamilyTree(List<Human> humanList) { this.humanList =humanList; }

    public boolean add(Human human){
        if (human == null){
            return false;
        }
        if (!humanList.contains(human)) {
            humanList.add(human);
            human.setId((humansId++));

            addToParents(human);
            addToChildren(human);

            return true;
        }
        return false;
    }

    private void addToParents(Human human) {
        for (Human parent: human.getParents()){
            parent.addChild(human);
        }
    }

    private void addToChildren(Human human) {
        for (Human child: human.getChildren()) {
            child.addParent(human);
        }
    }

    private boolean checkId(long id) {
        return id <humansId && id >= 0;
    }

    public Human getByID(long) {
        if (checkId(id)) {
            for (Human human : humanList) {
                if (human.getId() == id) {
                    return human;
                }
            }
        }
        return null;
    }

    public String toString() {
        return getInfo();
    }

    public String getInfo() {
        StringBuilder sb = new StringBuilder();
        sb.append("В дереве ");
        sb.append(humanList.size());
        sb.append(" объектов: \n");
        for (Human human: humanList) {
            sb.append(human);
            sb.append("\n");
        }
        return sb.toString();
    }


}
