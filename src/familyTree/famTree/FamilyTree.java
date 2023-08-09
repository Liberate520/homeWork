package familyTree.famTree;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import human.Human;

public class FamilyTree implements Serializable {
    private int id;
    private int humanId;
    private List<Human> humanList;

    public FamilyTree(int id) {
        this.id = id;
        humanList = new ArrayList<>();
    }

    public void addHuman(Human human){
        human.setId(humanId++);
        humanList.add(human);
    }

    public String getHumansInfo(){
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Члены семьи:\n");
        for (Human human: humanList){
            stringBuilder.append(human);
            stringBuilder.append("\n");
        }
        return stringBuilder.toString();
    }
}