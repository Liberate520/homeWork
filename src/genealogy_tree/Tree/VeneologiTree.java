package genealogy_tree.Tree;

import genealogy_tree.Human.*;


import java.util.ArrayList;
import java.util.List;


    public class VeneologiTree  {
    private List<Human> humanList;

    public VeneologiTree(){
        humanList = new ArrayList<>();
    }

    public void addHuman(Human human){
        humanList.add(human);
    }
    public String getHumanInfo(){
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("List Human:\n");
        for (Human human: humanList){
            stringBuilder.append(human);
            stringBuilder.append("\n");
        }
        return stringBuilder.toString();
    }


}