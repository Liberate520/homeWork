package Tree;

import java.util.HashMap;
import java.util.Map;

public class FamilyTree {
    private HashMap<Integer, Human> HumanList;
    private int HumanId = 0;
    public FamilyTree() {
        this.HumanList = new HashMap<Integer, Human>();
    }

    public void addHuman(Human Human){
        this.HumanList.put(HumanId++,Human);
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
        for (Map.Entry<Integer, Human> item : HumanList.entrySet()){
            System.out.println(item.getValue().toString());
        }
    }
}
