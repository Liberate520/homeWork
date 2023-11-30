package model.service;

import model.group.TreeItem;
import model.human.Gender;
import model.human.Human;
import model.group.FamilyTree;
import model.writer.FileHandler;

import java.io.File;
import java.io.FileNotFoundException;
import java.time.LocalDate;
import java.util.Scanner;

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
        tree = (FamilyTree)handler.read(filename);
    }

    public void save() {
        handler.save(tree, filename);
    }

    public void addFP(int humanId, int parentId) {
        Human child = tree.getHumanById(humanId);
        Human parent = tree.getHumanById(parentId);
        child.setFirstParent(parent.getName());
        parent.addChild(child);
    }

    public void importTree() {
        FamilyTree tree = new FamilyTree();
        String file;
        String[] word;
        String filename = "./Family_Tree_In.txt";
        Scanner sc = null;
        try {
            sc = new Scanner(new File(filename));
            while (sc.hasNextLine()) {
                file = sc.nextLine();
                word = file.split(",");
                for (int i = 0; i < word.length; i++) {
                    word[i] = word[i].trim();
                }
                int human_ID = Integer.parseInt(word[0], 10);
                int first_parent_ID;
                if (!word[1].isEmpty()) first_parent_ID = Integer.parseInt(word[1], 10);
                else first_parent_ID = -1;
                LocalDate ld = LocalDate.parse(word[3]);
                Gender gen = Gender.valueOf(word[4]);
                Human name = new Human(human_ID, first_parent_ID, word[2], ld, gen, word[5]);
                tree.addHuman((TreeItem) name);
            }
        }
        catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        tree.addFirstParent();
//  System.out.println(tree.getInfo());
    }
}