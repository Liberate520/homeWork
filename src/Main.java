import java.io.Serializable;
import java.util.*;

public class Main {
    public static void main(String[] args) {
//        Human person1 = new Human("Petr", Gender.Male);
//        Human person2 = new Human( "Nina", Gender.Female);
//        Human person3 = new Human("Serg", Gender.Male, person2, person1);
//        Human person4 = new Human("Sara", Gender.Female);
//        person3.setFather(person1);
//        person4.setFather(person1);
//        person3.setMother(person2);
//        person4.setMother(person2);
//        person1.addChild(person3);
//        person1.addChild(person4);
        String filePath = "/Users/mihaillazarenko/Documents/Программа разработчик/ООП/OOP_homeWork/src/tree.txt";
        Writable writable = new FileHandler();
        Tree tree = new Tree();
        tree.add(new Human("Petr", Gender.Male));
        tree.add(new Human("Nina", Gender.Female));
        tree.add(new Human("Serg", Gender.Male, tree.getByName("Petr"), tree.getByName("Nina")));
        tree.add(new Human("Sara", Gender.Female, tree.getByName("Petr"), tree.getByName("Nina")));
        writable.read(filePath);
        System.out.println(tree.getInfo());
    }
}


