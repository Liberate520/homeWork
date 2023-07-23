package FamilyTree.Tree.Tree;

import FamilyTree.Tree.Human.Human;

import java.util.ArrayList;
import java.util.List;

public class Tree {
    protected   List<Human> humanList;

    public Tree() {
        humanList = new ArrayList<>();
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
}
