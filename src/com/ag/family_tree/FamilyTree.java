package com.ag.family_tree;

import java.util.ArrayList;
import java.util.List;

public class FamilyTree {
    private List<Human> humanList;

    public FamilyTree() {
        humanList = new ArrayList<>();
    }
    public void addParents(Human name){
        humanList.add(name);
    }
    public void addChild(Human child){
        humanList.add(child);
    }

    public String getHumanListInfo() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Family tree:\n");
        for (Human human: humanList){
            stringBuilder.append(human);
            stringBuilder.append("\n");
        }
        return stringBuilder.toString();
    }

    @Override
    public String toString() {
        return getHumanListInfo();
    }
}

