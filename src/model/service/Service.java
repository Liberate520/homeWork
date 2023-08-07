package model.service;

import model.family_tree.FamilyTree;
import model.human.Human;
import model.work_with_file.ReadToFile;
import model.work_with_file.WriteToFile;

import java.time.LocalDate;

public class Service {
    private FamilyTree<Human> humanFamilyTree;

    public Service() {
        humanFamilyTree = new FamilyTree<>();
    }

    public void addHuman(String name, LocalDate birthDay, LocalDate deathDay) {
        Human human = new Human(name, birthDay, deathDay);
        humanFamilyTree.addHuman(human);
    }

    public void marry(int firstHuman, int secondHuman) {
        humanFamilyTree.marry(humanFamilyTree.getHumanList().get(firstHuman-1),
                humanFamilyTree.getHumanList().get(secondHuman-1));
    }

    public void addChild(int parent, int child) {
        humanFamilyTree.addChild(humanFamilyTree.getHumanList().get(parent-1),
                humanFamilyTree.getHumanList().get(child-1));
    }

    public void addParent(int child, int parent) {
        humanFamilyTree.addParent(humanFamilyTree.getHumanList().get(child-1),
                humanFamilyTree.getHumanList().get(parent-1));
    }

    public String outputInfo(){
        return humanFamilyTree.toString();
    }

    public void sortByName() {
         humanFamilyTree.sortByName();
    }

    public void sortByBirthDay() {
        humanFamilyTree.sortByDateBirthDay();
    }

    public String outputNumHumanList() {
        StringBuilder stringBuilder = new StringBuilder();
        for(int i = 0 ; i < humanFamilyTree.getHumanList().size(); i++) {
            stringBuilder.append(i+1);
            stringBuilder.append(". ");
            stringBuilder.append(humanFamilyTree.getHumanList().get(i).toString());
            stringBuilder.append("\n");
        }
        return stringBuilder.toString();
    }

    public int getCountHuman() {
        return humanFamilyTree.getHumanList().size();
    }

    public void saveInFile(String path) {
        WriteToFile writeToFile = new WriteToFile(path);
        writeToFile.write(humanFamilyTree);
    }

    public void loadFromFile(String path) {
        ReadToFile readToFile = new ReadToFile(path);
        humanFamilyTree = readToFile.read();
    }
}
