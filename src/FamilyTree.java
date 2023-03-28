

import java.util.ArrayList;
import java.util.List;

public class FamilyTree {
    private List<Human> humans = new ArrayList<>();

    public FamilyTree(List<Human> humans) {
        this.humans = humans;
    }

    public FamilyTree() {
        this(new ArrayList<>());
    }

    public List<Human> getFamilyTree() {
        return humans;
    }

    public void setFamily(List<Human> humans) {
        this.humans = humans;
    } 

    public void addMember(Human humans){
        this.humans.add(humans);
    }

    // public List<Human> addChild(List<Human> children) {
    //     List<Human> child = new ArrayList<>();
    //     for (int i = 0; i < humans.size(); i++) {
    //         if (humans.get(i).getFather() != null || humans.get(i).getMother() != null) {
    //             child.add(humans.get(i));
    //         }
    //     }
    //     return child;
    // }


    @Override
    public String toString() {
        return humans.toString();
    }
}
