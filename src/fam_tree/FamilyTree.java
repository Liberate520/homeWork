package fam_tree;

import java.util.ArrayList;
import java.util.List;

public class FamilyTree {

    private long humansId;

    public List<Human> getHumanList() {
        return humanList;
    }

    public void setHumanList(List<Human> humanList) {
        this.humanList = humanList;
    }

    private List<Human> humanList;


    public FamilyTree() {
        this(new ArrayList<>());
    }



    public FamilyTree(List<Human> humanList) {
        this.humanList = humanList;
    }

    public long getHumansId() {
        return humansId;
    }

    public void setHumansId(long humansId) {
        this.humansId = humansId;
    }

    @Override
    public String toString() {
        return "FamilyTree{" +
                "humansId=" + humansId +
                ", humanList=" + humanList +
                '}';
    }

    public boolean add(Human human) {
        if (human == null) {
            return false;
        }
        if (!humanList.contains(human)) {
            humanList.add(human);
            human.addChild(humansId);

            addToParents(human);
            addToChildren(human);

            return true;

        }
        return false;
    }

    private void addToChildren(Human human) {
    }

    private void addToParents(Human human) {
    }
}
