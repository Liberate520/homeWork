package genealogy_tree.service;

import genealogy_tree.Human.Gender;
import genealogy_tree.Human.Human;
import genealogy_tree.Tree.GeneologiTree;
import genealogy_tree.WriterAndReader.FileHandler;

import java.time.LocalDate;
import java.util.Scanner;


public class Service {
    private GeneologiTree tree;
    private int id;
    private FileHandler fileHandler;
    Scanner scanner = new Scanner(System.in);

    public Service() {
        tree = new GeneologiTree();
        fileHandler = new FileHandler();
    }

    public String getOperations() {
        String text = "Choose an operation: \n" +
                "1. Display family trees\n" +
                "2. Sort them by age of people. \n" +
                "3. Sort them by Name \n" +
                "4. Exit";
        System.out.println(text);
        String choise = scanner.next();
        return choise;
    }

    public void start() {
        boolean flag = true;
        while (flag) {
            String operation = getOperations();
            if (operation.equals("4")) {
                flag = false;
                scanner.close();
                continue;
            } else if (operation.equals("1")) {
                System.out.println(getInfo());

            } else if (operation.equals("2")) {
                sortByAge();
                System.out.println(getInfo());
            } else if (operation.equals("3")) {
                sortByName();
                System.out.println(getInfo());
            }
        }
    }

    public void addHuman(String name, Gender gender, LocalDate birthDate) {

        Human human = new Human(id++, name, gender, birthDate);
        tree.addHuman(human);
        tree.setWedding(human, human);
        tree.setDivorce(human, human);
        human.addParents(human);
        human.addChild(human);
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

    public void sortByName() {
        tree.sortByName();
    }

    public void sortByAge() {
        tree.sortByAge();
    }
}
