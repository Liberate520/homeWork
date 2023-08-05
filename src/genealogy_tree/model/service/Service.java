package genealogy_tree.model.service;

import genealogy_tree.model.Human.Gender;
import genealogy_tree.model.Human.Human;
import genealogy_tree.model.Tree.GeneologiTree;

import genealogy_tree.model.WriterAndReader.FileHandler;
import genealogy_tree.ui.ConsoleUI;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;


public class Service {
    private GeneologiTree tree;

    private FileHandler fileHandler;

    Scanner scanner = new Scanner(System.in);

    public Service() {
        tree = new GeneologiTree();
        fileHandler = new FileHandler();
    }

    public void sortByName() {
        tree.sortByName();
    }


    public void sortByAge() {
        tree.sortByAge();
    }


    public void addHuman(int id, String name, Gender gender, LocalDate birthDate) {

        Human human = new Human(id, name, gender, birthDate);
        tree.addHuman(human);

    }

    public void addParents(int id, int ids) {
        try {
            tree.addParentsHuman(id, ids);
        } catch (NullPointerException e) {
            ConsoleUI.answerError();
        }
    }

    public void addChildren(int id, int ids) {
        try {
            tree.addChildren(id, ids);
        } catch (NullPointerException e) {
            ConsoleUI.answerError();
        }
    }

    public void getSiblings(int id) {
        try {
            tree.getSiblingsHuman(id);
        } catch (NullPointerException e) {
            ConsoleUI.answerError();
        }
    }

    public void setDivorce(int id, int ids) {
        try {
            tree.setDivorceHuman(id, ids);
        } catch (NullPointerException e) {
            ConsoleUI.answerError();
        }
    }

    public void addSpouse(int id, int ids) {
        try {
            tree.addSpouseHuman(id, ids);
        } catch (NullPointerException e) {
            ConsoleUI.answerError();
        }

    }

    public String getInfo() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Human list:\n");

        for (Object human : tree) {
            stringBuilder.append(human);
            stringBuilder.append("\n");
        }
        return stringBuilder.toString();

    }


}
