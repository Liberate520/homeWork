package Homework.Tree;

import Homework.Human.Comparators.HumanComporatorByAge;
import Homework.Human.Comparators.HumanComporatorByName;
import Homework.Human.Comparators.HumanComporatorByChildren;
import Homework.Human.Human;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class FamilyTree implements Serializable {
    //TODO добавить ID
    private List<Human> familyList;

    public FamilyTree() {
        familyList = new ArrayList<>();
    }

    public boolean addHuman(Human human) {
        if(human == null){
            return false;
        }
        if(!familyList.contains(human)) {
            familyList.add(human);

            addToParents(human);
            addToChildren(human);
            return true;
        }
        return false;
    }

    private void addToParents(Human human){
        for(Human parent: human.getParents()){
            parent.addChild(human);
        }
    }

    private void addToChildren(Human human){
        for(Human child: human.getChildren()){
            child.addParent(human);
        }
    }

    public Human getByName(String name){
        for (Human human: familyList){
            if(human.getName().equals(name)){
                return human;
            }
        }
        return null;
    }

    public String getHumanInfo() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("В дереве ");
        stringBuilder.append(familyList.size());
        stringBuilder.append(" объектов.\n");
        stringBuilder.append("Семья:\n");
        for (Human human : familyList) {
            stringBuilder.append(human);
            stringBuilder.append("\n");
        }
        return stringBuilder.toString();
    }

    public void getBrotherInfo(Human human) {
        List<String> bros = new ArrayList<>();
        for (Human bro : familyList) {
            if (bro.getMother() != null && bro.getMother() != null) {
                if (!bro.getName().equals(human.getName()) && (bro.getFather().equals(human.getFather()) || bro.getMother().equals(human.getMother()))) {
                    bros.add(bro.getName() + "(" + bro.getAge() + " лет)");
                }
            }
        }

        if (bros.isEmpty()) {
            System.out.println("Извините! Данных о братьях/сестрах " + human.getName() + " нет!");
        } else {
            System.out.println("Братья/сестры " + human.getName() + ":");
            for (String br : bros) {
                System.out.println("- " + br);
            }
        }
    }

    public void sortByName(){
        familyList.sort(new HumanComporatorByName());
    }

    public void sortByAge(){
        familyList.sort(new HumanComporatorByAge());
    }

    public void sortByChildren(){
        familyList.sort(new HumanComporatorByChildren());
    }

}
