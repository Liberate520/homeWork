package FamilyTree.Tree.Tree;

import FamilyTree.Tree.HumanGroup.Human.Human;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Tree implements Serializable {
    private   List<Human> humanList;

    public Tree(List<Human> humanList) {
        this.humanList = humanList;
    }
    public Tree(){
        this(new ArrayList<>());
    }
    public boolean add(Human human){
        if (human == null){
            return false;
        }
        if ( !humanList.contains(human)){
            humanList.add(human);

            return true;
        }
        return false;
    }
    public String getHumansInfo(){
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Список людей: \n");
        for (Human human: humanList){
            stringBuilder.append(human);
            stringBuilder.append("\n");
        }
        return stringBuilder.toString();
    }
    @Override
    public String toString(){
        return getHumansInfo();
    }
}
