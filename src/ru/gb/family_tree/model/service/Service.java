package ru.gb.family_tree.model.service;

import ru.gb.family_tree.model.family_tree.FamilyTree;
import ru.gb.family_tree.model.human.Gender;
import ru.gb.family_tree.model.human.Human;
import ru.gb.family_tree.model.writer.FileHandler;
import java.time.LocalDate;

public class Service {
    private FamilyTree familyTree;
    private boolean choice = true;

    public Service() {
        this.familyTree = new FamilyTree<>();
    }

    public void loadTree() {
        String filePath = "src/ru.gb.family_tree/model/writer/tree.txt";
        FileHandler fileHandler = new FileHandler();
        familyTree = (FamilyTree) fileHandler.load(filePath);
    }

    public void saveTree() {
        String filePath = "src/ru.gb.family_tree/model/writer/tree.txt";
        FileHandler fileHandler = new FileHandler();
        fileHandler.save(familyTree, filePath);
    }

    public void addHuman(String name, String genderStr, LocalDate birthDate) {
        Human human;
        switch (genderStr) {
            case "Male":
                human = new Human(name, Gender.Male, birthDate);
                familyTree.add(human);
                break;
            case "Female":
                human = new Human(name, Gender.Female, birthDate);
                familyTree.add(human);
                break;
            default:
                System.out.println("неправильный пол");
                choice = false;
                break;
        }


    }

    public String getTreeInfo() {
        return familyTree.toString();
    }

    public void addHumanAndParents(String name, String genderStr, LocalDate birthDate, int id1, int id2) {
        Human human;
        switch (genderStr) {
            case "Male":
                human = new Human(name, Gender.Male, birthDate, (Human) familyTree.getById(id1), (Human) familyTree.getById(id2));
                familyTree.add(human);
                break;
            case "Female":
                human = new Human(name, Gender.Female, birthDate, (Human) familyTree.getById(id1), (Human) familyTree.getById(id2));
                familyTree.add(human);
                break;
            default:
                System.out.println("неправильный пол");
                choice = false;
                break;
        }
    }


}