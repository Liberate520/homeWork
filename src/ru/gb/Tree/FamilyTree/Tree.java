package ru.gb.Tree.FamilyTree;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import ru.gb.Tree.Human.Human;


public class Tree implements Serializable{
    private List<Human>humanList;

    public Tree(){
        humanList = new ArrayList<>();
    }

    public void addHuman(Human human){
        humanList.add(human);
    }

    public static void setWedding(Human human1, Human human2){
        if (human1.getSpouse()== null && human2.getSpouse()==null){
            human1.setSpouse(human2);
            human2.setSpouse(human1);
            } 
    }

    public String getFamilyTreeInfo(){
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Семья состоит из:\n");
        for (Human human : humanList) {
            stringBuilder.append(human);
            stringBuilder.append("\n");
        }
        return stringBuilder.toString();
    }
   
    @Override
    public String toString(){
        return getFamilyTreeInfo();
    }

}
