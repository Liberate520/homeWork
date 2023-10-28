package HomeWork.familyTree.homeWork22_10_23.src.tree;

import HomeWork.familyTree.homeWork22_10_23.src.human.Human;

import java.util.ArrayList;
import java.util.List;



public class FamilyTree {

    private List<Human> humanList ;


    public FamilyTree(){
        humanList = new ArrayList<>();

    }


    public String getHumanListInfo(){
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Список людей : \n");
        for(Human human:humanList){
            stringBuilder.append(human.getSurname());
            stringBuilder.append(human.getName());
            stringBuilder.append(human.getPatronymic());
            stringBuilder.append(human.getAge().getYear());
            stringBuilder.append("\n");
        }
        return stringBuilder.toString();
    }

    public void addHuman(Human human){
        humanList.add( human);

    }



}




