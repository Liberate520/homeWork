package ru.gb.family_tree.model.service;

import ru.gb.family_tree.model.familytree.FamilyTree;
import ru.gb.family_tree.model.human.Gender;
import ru.gb.family_tree.model.human.Human;

import java.time.LocalDate;
import java.util.List;


public class Service {
    private int index;
    private FamilyTree familyTree;
    private List<Human> humanList;


    public Service() {
        FamilyTree familyTree;
        List<Human> humanList;
    }
    public String getInfo( ){
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Family tree:\n");
        for (Human human: humanList){
            stringBuilder.append(human.getInfo());
            stringBuilder.append("\n");
        }

        return stringBuilder.toString();
    }
    public void addHuman(String name, LocalDate birthDate, LocalDate deathDate, Gender gender){
        Human human=new Human ( name, birthDate, deathDate,gender);
        familyTree.addHuman(human);
    }
    public void addHuman(String name, LocalDate birthDate,  Gender gender){
        Human human=new Human ( name, birthDate, null,gender);
        familyTree.addHuman(human);
    }
    public void sortByName(){
        familyTree.sortByName();
    }

    public void sortByAge() {
        familyTree.sortByAge();
    }
}
