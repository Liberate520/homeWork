import Tree.FamilyTree;
import Tree.Gender;
import Tree.Person;
import Utils.StorageTree;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class Main {
    public static void main(String[] args) throws IOException {
        FamilyTree tree = new FamilyTree();
        StorageTree storage = new StorageTree();
        String filepath = "tree.out";

        Person person  = new Person("Ann", Gender.female, "2022-01-01");
        Person parent1 = new Person("Bet", Gender.female,"1989-01-01");
        Person parent2 = new Person("Bob", Gender.male,"1989-01-01");
        Person grandma = new Person("Mary", Gender.female,"1966-01-01");

        tree.addPerson(person);
        tree.addPerson(parent1);
        tree.addPerson(parent2);
        tree.addPerson(grandma);

        tree.setParent1(person,parent1);
        tree.setParent2(person,parent2);
        tree.setParent1(parent1,grandma);

        //tree.printTree();
        System.out.println(tree.toString());
        storage.writeTree(tree, filepath);
        FamilyTree newTree = storage.restoreTree(filepath);
        //newTree.printTree();
        System.out.println(newTree.toString());


    }
}
