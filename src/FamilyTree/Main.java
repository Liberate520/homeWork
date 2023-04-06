package FamilyTree;

import FamilyTree.FamilyTree.FamilyTree;
import FamilyTree.Human.Gender;
import FamilyTree.Human.Human;
import FamilyTree.Writable.FileHandler;
import FamilyTree.Writable.Writable;

import java.io.IOException;


public class Main {
    public static void main(String[] args) throws IOException, ClassNotFoundException {

        FamilyTree tree = new FamilyTree("Johnson");

        tree.addHuman(new Human("John", Gender.MALE, "25.08.1965"));
        tree.addHuman (new Human("Sarah", Gender.FEMALE, "12.10.1966"));
        tree.addHuman (new Human("Charlie", Gender.MALE, "05.07.1988"));
        tree.addHuman (new Human("Marie", Gender.FEMALE, "10.09.1987"));
        tree.addHuman (new Human("Jack", Gender.MALE, "08.08.2008", tree.getByName("Charlie"),
                tree.getByName("Marie")));
        tree.addHuman (new Human("Hellen", Gender.FEMALE, "15.15.2009"));

        tree.addChild(tree.getByName("John"),tree.getByName("Sarah"),tree.getByName("Charlie"));
        tree.addChild(tree.getByName("Charlie"),tree.getByName("Marie"),tree.getByName("Hellen"));
        tree.getAllChild(tree.getByName("John"));
        tree.getAllChild(tree.getByName("Charlie"));
        tree.humanDie(tree.getByName("John"), "20.01.2023");
        tree.getParentsInfo(tree.getByName("Charlie"));
        tree.save("Tree.out");
        tree.getAllChild(tree.getByName("John"));

        Writable writable = new FileHandler();
        tree = (FamilyTree) writable.load("C:/Users/Виктор Егоров/homeWork/Tree.out");
        tree.getAllChild(tree.getByName("John"));




    }
}
