package Classes;

import java.util.ArrayList;
import java.util.List;

public class FamilyTree {
    private List<Human>humanList;

    public FamilyTree(List<Human> humanList){
        this.humanList =humanList;
    }

    public FamilyTree(){
        this (new ArrayList<>());
    }
    public String getInfo(){
        StringBuilder tmpSb = new StringBuilder();
        tmpSb.append("Дерево содержит :");
        tmpSb.append(humanList.size());
        tmpSb.append("/n");
        for(Human human: humanList){
            tmpSb.append(human);
            tmpSb.append("/n");
        }
        return tmpSb.toString();
    }

    public String toString(){
        return getInfo();
    }
}
