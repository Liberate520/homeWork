package genealogy_tree.model.service;

import genealogy_tree.model.Human.Gender;
import genealogy_tree.model.Human.Human;
import genealogy_tree.model.Tree.GeneologiTree;
import genealogy_tree.model.Tree.GeneologiTreeItem;
import genealogy_tree.model.WriterAndReader.FileHandler;

import java.time.LocalDate;
import java.util.ArrayList;
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

        Human human = new Human(id++, name, gender, birthDate);
        tree.addHuman(human);

    }

    public void addParents() {
        try{
            System.out.println("Who is person");
            int choise = scanner.nextInt();
            int id = choise;
            tree.checkId(id);
            tree.getById(id);
            Human human = (Human) tree.getById(id);
            System.out.println("Who is parents");
            int choiseParents = scanner.nextInt();
            int ids = choiseParents;
            tree.checkId(ids);
            tree.getById(ids);
            Human human1 = (Human) tree.getById(ids);
            System.out.println("Add parents");
            tree.addParents(human1);
            human.addParents(human1);
        } catch (NullPointerException e){
            System.out.println("Not human");
        }
    }

    public void addChildren() {
        System.out.println("Who is person");
        int choise = scanner.nextInt();
        int id = choise;
        tree.checkId(id);
        tree.getById(id);
        Human human = (Human) tree.getById(id);
        System.out.println("Who is your children?");
        int choiseChildren = scanner.nextInt();
        int ids = choiseChildren;
        tree.checkId(ids);
        tree.getById(ids);
        Human human2 = (Human) tree.getById(ids);
        System.out.println("Add children");
        tree.addToChildren(human2);
        human.addChild(human2);


    }

    public void getSiblings(){
        System.out.println("Who is person");
        int choise = scanner.nextInt();
        int id = choise;
        tree.checkId(id);
        tree.getById(id);
        System.out.println("Siblings a person");
        tree.getSiblings(id);
        List<String> result = tree.getSiblings(id);
        System.out.println(result);
    }

    public void setDivorce() {
        System.out.println("Whi is person");
        int choise = scanner.nextInt();
        int id = choise;
        tree.checkId(id);
        tree.getById(id);
        Human human = (Human) tree.getById(id);
        System.out.println("Choose a spose");
        int choiseSpouse = scanner.nextInt();
        int ids = choiseSpouse;
        tree.checkId(ids);
        tree.getById(ids);
        Human human1 = (Human) tree.getById(ids);
        tree.setDivorce(human,human1);
    }
    public void addSpouse() {
        System.out.println("Who is person");
        int choise = scanner.nextInt();
        int id = choise;
        tree.checkId(id);
        tree.getById(id);
        Human human = (Human) tree.getById(id);
        System.out.println("Choose a spouse");
        int choiseSpouse = scanner.nextInt();
        int ids = choiseSpouse;
        tree.checkId(ids);
        tree.getById(ids);
        Human human3 = (Human) tree.getById(ids);
        System.out.println("Add spouse");
        tree.setWedding(human,human3);

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
