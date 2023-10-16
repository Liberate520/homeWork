package Tree;

import Human.Human;

import java.util.ArrayList;
import java.util.List;

public class familyTree {
    private List<Human> HumanList;
    public familyTree(){
        HumanList = new ArrayList<>();
    }
    public void addHuman(Human human) {
        if (!HumanList.contains(human)) {
            HumanList.add(human);
        }
    }

    public String getInfoHuman(){
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("\n Люди:\n");
        for (Human human: HumanList){
            stringBuilder.append(human.getName());
            stringBuilder.append("\n");
        }
        return stringBuilder.toString();
    }
}