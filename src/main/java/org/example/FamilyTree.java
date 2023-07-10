package org.example;
//1
import java.util.ArrayList;
import java.util.List;

public class FamilyTree {
    private static List<Human> humanList;
    private int id;
    private int humanId;


    public FamilyTree(int id) {
        this.id = id;
        humanList = new ArrayList<>();
    }

    public void addHuman(Human human) {
        human.setId(humanId++);
        humanList.add(human);
        // addToChildren(human);
        //addToParent(human);
    }
    /*public void addToParent(Human human){
        if (human.getFather()!=null) human.getFather().addChild(human);
        if (human.getMother()!=null) human.getMother().addChild(human);
    }
    public void addToChildren(Human human){
        for (Human child:human.getChildren()) {
            child.addParent(human);
        }
    }
    */
    public static String getHumanInfo() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Family tree:\n");
        for (Human human: humanList){
            stringBuilder.append(human);
            stringBuilder.append("\n");
        }
        //stringBuilder.append(getChildrenInfo);
        return stringBuilder.toString();
    }
}
