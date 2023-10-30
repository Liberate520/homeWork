package Tree;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class FamilyTree implements Serializable {
    private HashMap<Integer, Human> humanList;
    private int humanId = 0;
    public FamilyTree() {
        this.humanList = new HashMap<Integer, Human>();
    }

    public void addHuman(Human Human){
        this.humanList.put(humanId++,Human);
    }

    public void setParent1(Human Human, Human parent){
        Human.setParent1(parent);
        if (! parent.getChildren().contains(Human)){
            parent.addChild(Human);
        }
    }
    public void setParent2(Human Human, Human parent){
        Human.setParent2(parent);
        if (! parent.getChildren().contains(Human)){
            parent.addChild(Human);
        }
    }

    public void printTree(){
        for (Map.Entry<Integer, Human> item : humanList.entrySet()){
            System.out.println(item.getValue().toString());
        }
    }
}
