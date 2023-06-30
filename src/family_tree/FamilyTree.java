package family_tree;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class FamilyTree implements Serializable {
    private static final long serialVersionUID = 1L;
    private List<Human> humanList = new ArrayList<>();


    public List<Human> getHumanList() {
        return humanList;
    }

    public void setHumanList(List<Human> humanList) {
        this.humanList = humanList;
    }

    public void addToHumanList(Human human) {
        this.humanList.add(human);
    }

    public void clearHumanList() {
        this.humanList.clear();
    }



    @Override
    public String toString() {
        return "Семейное древо.\n" +
                "Члены семьи: " + humanList;
    }
}
