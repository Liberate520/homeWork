package faminly_tree;

import faminly_tree.human.Gender;
import faminly_tree.human.Human;
import faminly_tree.save_in_file.SaveInFile;
import faminly_tree.tree.FamilyTree;
import faminly_tree.tree.HumanIterator;
import faminly_tree.tree.TreeSort;

import java.io.IOException;
import java.time.LocalDate;

public class Test {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        FamilyTree tree = new FamilyTree();
        Human human1 = new Human("Darya", Gender.Female, LocalDate.of(1996, 10, 17));
        tree.addToTree(human1);
        Human human2 = new Human("Aleksey", Gender.Male, LocalDate.of(1967, 1, 03));
        tree.addToTree(human2);
        human1.childFor(human2);
        Human human3 = new Human("Elizaveta", Gender.Female, LocalDate.of(2000, 8, 10));
        tree.addToTree(human3);
        human3.childFor(human2);
        Human human4 = new Human("Elena", Gender.Female, LocalDate.of(1969, 12, 24));
        human1.childFor(human4);
        tree.addToTree(human4);
        Human human5 = new Human("Ivan", Gender.Male, LocalDate.of(2020, 5, 12));
        human5.childFor(human2);
        tree.addToTree(human5);
       // System.out.println(tree.nextOfKin(human1));

        //HomeWork2
        SaveInFile sv = new SaveInFile();
        sv.write("tree.out", tree);
        //System.out.println(sv.readTree("tree.out"));
        sv.write("human.out", human1);
        //System.out.println(sv.readHuman("human.out"));

        //HomeWork3
        for(Object human: tree){
            System.out.println(human);
        }

        TreeSort sort = new TreeSort(tree.getTree());
        System.out.println("Сортировка по имени:");
        sort.sortByName();
        for(Object human: tree){
            System.out.println(human);
        }

        System.out.println("Сортировка по дате рождения:");
        sort.sortByAge();
        for(Object human: tree){
            System.out.println(human);
        }

        System.out.println("Сортировка по возрасту:");
        sort.sortByAge();
        for(Object human: tree){
            System.out.println(human);
        }
    }
}
