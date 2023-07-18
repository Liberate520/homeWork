package ru.gb.family_tree.model;

import ru.gb.family_tree.model.human.Gender;
import ru.gb.family_tree.model.human.Human;
import ru.gb.family_tree.model.save_print_file.FileHandler;
import ru.gb.family_tree.model.tree.FamilyTree;

import java.time.LocalDate;

public class Service {
    public FamilyTree<Human> tree;

    public Service() {
        tree = new FamilyTree<>();
    }

    public void addHuman(String fullName, Gender gender, LocalDate dateOfBirth, String father, String mother) {
        Human human = new Human(fullName ,gender, dateOfBirth, father, mother);
        tree.addHuman(human);
    }



    public String getInfo() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Семейное древо:\n");
        for (Human human: tree){
            stringBuilder.append(human.getInfo());
            stringBuilder.append("\n");
        }
        return stringBuilder.toString();
    }
    public String toString() {
        return getInfo();
    }
    public void sortByFullName(){
        tree.sortByFullName();
    }

    public void sortByAge() {
        tree.sortByAge();
    }

    public void saveFile() {
        FileHandler fileHandler = new FileHandler();
        fileHandler.save(tree, fileHandler.filePath);
    }

    public void readFile() {
        FileHandler fileHandler = new FileHandler();
        tree = (FamilyTree) fileHandler.read(fileHandler.filePath);
        getInfo();

    }
}