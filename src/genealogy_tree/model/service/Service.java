package genealogy_tree.model.service;

import genealogy_tree.model.Human.Gender;
import genealogy_tree.model.Human.Human;
import genealogy_tree.model.Tree.GeneologiTree;

import genealogy_tree.model.WriterAndReader.FileHandler;

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
            tree.checkId(id);
            tree.getById(id);
            Human human = (Human) tree.getById(id);
            tree.checkId(ids);
            tree.getById(ids);
            Human human1 = (Human) tree.getById(ids);
            tree.addParents(human1);
            human.addParents(human1);
        } catch (NullPointerException e) {
            System.out.println("No human");
        }
    }

    public void addChildren(int id, int ids) {
        try {
            tree.checkId(id);
            tree.getById(id);
            Human human = (Human) tree.getById(id);
            tree.checkId(ids);
            tree.getById(ids);
            Human human2 = (Human) tree.getById(ids);
            tree.addToChildren(human2);
            human.addChild(human2);
        } catch (NullPointerException e) {
            System.out.println("No human");
        }
    }

    public void getSiblings(int id) {
        try {
            tree.checkId(id);
            tree.getById(id);
            tree.getSiblings(id);
            List<String> result = tree.getSiblings(id);
            System.out.println(result);
        } catch (NullPointerException e) {
            System.out.println("No human");
        }
    }

    public void setDivorce(int id, int ids) {
        try {
            tree.checkId(id);
            tree.getById(id);
            Human human = (Human) tree.getById(id);
            tree.checkId(ids);
            tree.getById(ids);
            Human human1 = (Human) tree.getById(ids);
            tree.setDivorce(human, human1);
        } catch (NullPointerException e) {
            System.out.println("No human");
        }
    }

    public void addSpouse(int id, int ids) {
        try {
            tree.checkId(id);
            tree.getById(id);
            Human human = (Human) tree.getById(id);
            tree.checkId(ids);
            tree.getById(ids);
            Human human3 = (Human) tree.getById(ids);
            tree.setWedding(human, human3);
        } catch (NullPointerException e) {
            System.out.println("No human");
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
