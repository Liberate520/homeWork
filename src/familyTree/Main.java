package familyTree;

import familyTree.familyTree.FamilyTree;
import familyTree.human.Gender;
import familyTree.human.Human;
import familyTree.service.HumanIterator;
import familyTree.writable.FileHandler;
import familyTree.writable.Writable;

import java.io.IOException;
import java.util.GregorianCalendar;
import java.util.Iterator;


public class Main {
    public static void main(String[] args) throws IOException, ClassNotFoundException {

        FamilyTree tree = new FamilyTree("Johnson");

        tree.addHuman(new Human("John", Gender.MALE, new GregorianCalendar(1966,11,15)));
        tree.addHuman (new Human("Sarah", Gender.FEMALE, new GregorianCalendar(1965,8,10)));
        tree.addHuman (new Human("Charlie", Gender.MALE, new GregorianCalendar(1988,7,05)));
        tree.addHuman (new Human("Marie", Gender.FEMALE, new GregorianCalendar(1987,9,10)));
        tree.addHuman (new Human("Jack", Gender.MALE, new GregorianCalendar(2008,8,8), tree.getByName("Charlie"),
                tree.getByName("Marie")));
        tree.addHuman (new Human("Hellen", Gender.FEMALE, new GregorianCalendar(2009,15,15)));

        tree.addChild(tree.getByName("John"),tree.getByName("Sarah"),tree.getByName("Charlie"));
        tree.addChild(tree.getByName("Charlie"),tree.getByName("Marie"),tree.getByName("Hellen"));
        tree.getAllChild(tree.getByName("John"));
        tree.getAllChild(tree.getByName("Charlie"));
        tree.humanDie(tree.getByName("John"), new GregorianCalendar(2023,01,23));
        tree.getParentsInfo(tree.getByName("Charlie"));
        tree.save("Tree.out");
        tree.getAllChild(tree.getByName("John"));

        Writable writable = new FileHandler();
        tree = (FamilyTree) writable.load("C:/Users/Виктор Егоров/homeWork/Tree.out");
        tree.getAllChild(tree.getByName("John"));
        Iterator<Human> iterator = tree.iterator();
        System.out.println(iterator.next().info());


    }
}
