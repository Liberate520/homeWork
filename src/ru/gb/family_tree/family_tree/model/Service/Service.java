package ru.gb.family_tree.family_tree.model.Service;

import ru.gb.family_tree.family_tree.model.FamilyTree;
import ru.gb.family_tree.family_tree.model.human.Gender;
import ru.gb.family_tree.family_tree.model.human.Human;
import ru.gb.family_tree.family_tree.model.human.HumanBuilder;

import java.time.LocalDate;

public class Service {
    private HumanBuilder builder;
    private FamilyTree familytree;

    public Service(){
        builder=new HumanBuilder();
        familytree=new FamilyTree<>();
    }
    public void addHuman(String name, Gender gender, LocalDate birthDate, Human mother, Human father){
        Human human = builder.build(name,gender,birthDate,mother,father);
        familytree.addToFamilyTree(human);
    }
    public void addHuman(String name,Gender gender,LocalDate birthDate,LocalDate deathDate,Human mother,Human father){
        Human human = builder.build(name,gender,birthDate,deathDate,mother,father);
        familytree.addToFamilyTree(human);
    }
    public void printFamilyTree(){
        familytree.printFamilyTree(familytree);
    }
}
