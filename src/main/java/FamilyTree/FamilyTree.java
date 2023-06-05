package FamilyTree;

import java.util.ArrayList;
import java.util.List;

public class FamilyTree {
    private List<Human> family;

    public FamilyTree (){
        family = new ArrayList<>();
    }

    public void addToFamily(Human human) {
        this.family.add(human);
    }

    public List<Human> findChildren(String name){
        for (Human human: family){
            if (human.getName().equalsIgnoreCase(name)){
                return human.getChildren();
            }
        }
        return null;
    }
}
