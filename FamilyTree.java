package homeWork_Oop;

import homeWork_Oop.Human.Human;

import java.util.ArrayList;
import java.util.List;

public class FamilyTree {
    private List<Human> humanList;
    public FamilyTree(List<Human> humanList) {
        this.humanList = humanList;
    }
    public FamilyTree() {
        this(new ArrayList<>());
    }
    public boolean add (Human human){
        humanList.add(human);
        return true;
    }

    public String getInfo(){
        StringBuilder sb = new StringBuilder();
        sb.append("В дереве");
        sb.append(humanList.size());
        sb.append(" объектов:\n");
        for (Human human: humanList){
            sb.append(human);
            sb.append("\n");
        }
        return  sb.toString();
    }

    @Override
    public String toString() {
        return getInfo();
    }


}


