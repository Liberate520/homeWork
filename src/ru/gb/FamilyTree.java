package ru.gb;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class FamilyTree implements Serializable {
    private long humansId;
    private List<Human> humanList;
    public FamilyTree(){
        this(new ArrayList<>());
    }

    public FamilyTree(List<Human> humanList) {
        this.humanList = humanList;
    }

    public Human getHumanByName(String humanName) {
        for (Human human : humanList) {
            if (human.getName().equals(humanName)) {
                return human;

            }
        }

        return null;
    }


    public void addHuman(Human human) {

        if (!humanList.contains(human)) {
            humanList.add(human);
            human.setId(humansId++);
        }
    }
    public Human getById(long id){
        if (!checkId(id)) {
            return null;
        }
        for (Human human : humanList) {
            if (human.getId() ==id){
                return human;
            }
        }
        return null;
    }
    private  boolean checkId(long id){return id<humansId&&id>=0;}
    public String getHumanListInfo() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Семейное древо:\n");
        for (Human human : humanList
        ) {
            stringBuilder.append(human);
            stringBuilder.append("\n");


        }
        return stringBuilder.toString();

    }
}
