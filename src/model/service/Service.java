package model.service;

import model.human.Gender;
import model.human.Human;
import model.group.FamilyTree;
import model.writer.FileHandler;

import java.io.FileNotFoundException;
import java.time.LocalDate;

public class Service {
    private FamilyTree<Human> tree;
    private FileHandler handler;
    String filename = "./tree.txt";

    public Service() {
        tree = new FamilyTree<>();
    }

    public void addHuman(int human_Id, int parent_Id, String name, LocalDate birthday, Gender gender, String second_parent) {
        Human human = new Human(human_Id, parent_Id, name, birthday, gender, second_parent);
        tree.addHuman(human);
    }

    public String getHumanInfo() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Список :\n");
        for (Human k : tree) {
            stringBuilder.append(k);
            stringBuilder.append("\n");
        }
        return stringBuilder.toString();
    }

    public void sortByName() {
        tree.sortByName();
    }

    public void sortByAge() {
        tree.sortByAge();
    }
    public void load() {
        try {
            tree = (FamilyTree)handler.read(filename);
        }
        catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public void save() {
        handler.save(tree, filename);
    }
}