package Tree.homeWork.src;

import java.util.ArrayList;
import java.util.List;

public class FamilyTree {
    private List<Human> humanList;
    public FamilyTree(){
        humanList = new ArrayList<>();
    }
    public void addHuman(Human human){
        humanList.add(human);
    }
    public Human getHumanByName(String name){
        for (Human human: humanList){
            if (human.getName().equals(name)){
                return human;
            }
        }
        return null;
    }
    public List<Human> getHumanList() {
        return humanList;
    }
}
