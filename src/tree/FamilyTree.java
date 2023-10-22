package HomeWork.familyTree.homeWork22_10_23.src.tree;

import HomeWork.familyTree.homeWork22_10_23.src.human.Children;
import HomeWork.familyTree.homeWork22_10_23.src.human.Human;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;



public class FamilyTree {
    private List<Human> humanList ;
   private List<Human>parentList;

    public FamilyTree(){
        humanList = new ArrayList<>();
        parentList = new ArrayList<>();
    }


    public String getHumanListInfo(){
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Список людей : \n");
        for(Human human:humanList){
            stringBuilder.append(human);
            stringBuilder.append("\n");
        }
        return stringBuilder.toString();
    }

    public void addHuman(Human human){
        humanList.add(human);
    }
    public void addParent(Human human) {parentList.add( human);}

    public String getHumanChildrenListInfo(String name){

        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Дети " + name +": \n" );
        for(Human human:humanList){
            if(human.getName().equals(name)){
                stringBuilder.append(human.getChildrenList());
            }
        }
        return stringBuilder.toString();
    }


    public List<Human> searchForParents (String childName){
        List<Human> parents = new ArrayList<>();
        for (Human human : humanList) {
            if (human instanceof Children && human.getName().equals(childName)) {
                Children child = (Children) human;
                System.out.println("Родители " +childName +" : ");
                parents.add(child.getParentList().get(0));
                parents.add(child.getParentList().get(1));
                return parents;
            }
        }
        return null;
    }


    public Human searchForRelatives (String humanName){
        for (Human human : humanList) {
            if (human.getName().equals(humanName)) {
                return human;
            }
        }
        return null;
    }



    public List<Human> searchForSiblings (String humanName){
        List<Human> siblings = new ArrayList<>();
        for (Human human : humanList) {
            if (human instanceof Children && !human.getName().equals(humanName)) {
                Children child = (Children) human;
                if (child.getParentList().get(0) != null && child.getParentList().get(0).getName().equals(searchForRelatives(humanName).getName())) {
                    siblings.add(child);
                }
                if (child.getParentList().get(1) != null && child.getParentList().get(1).getName().equals(searchForRelatives(humanName).getName())) {
                    siblings.add(child);
                }
            }
        }
        return (List<Human>) siblings;
    }
    public Human removeHuman(String humanName) {
        for (Human human : humanList) {
            if (human.getName().equals(humanName)) {
                humanList.remove(human);
                return human;
            }
        }
        return null;
    }
    public String getDayOfDeadInfo(String humanName){
        for(Human human:humanList){
            if(human.getName().equals(humanName)){
                human.setDayOfDeath(LocalDate.now());
            }
        }
        return getHumanListInfo();
    }
}




