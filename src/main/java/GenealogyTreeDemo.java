package src.main.java;

import java.io.File;
import java.io.IOException;

public class GenealogyTreeDemo {
    public static void main(String[] args) {
        Person person1 = new Person("John Doe", Gender.MALE, 1985);
        Person person2 = new Person("Jane Smith", Gender.FEMALE, 1990);
        Person person3 = new Person("Bob Johnson", Gender.MALE, 1950);
        Person person4 = new Person("Sarah Lee", Gender.FEMALE, 1975);

        GenealogyTree tree = new GenealogyTree(person1);
        tree.addParent(person1, person3, person4);
        tree.addChild(person1, person2);

        System.out.println("All children of John Doe:");
        for (Person child : tree.getChildren(person1)) {
            System.out.println(child.getFullName());
        }

        GenealogyTreeWriter writer = new FileGenealogyTreeWriter();
        try {
            writer.save(tree, new File("genealogytree.txt"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        GenealogyTreeReader reader = new FileGenealogyTreeReader();
        try {
            GenealogyTree loadedTree = reader.load(new File("genealogytree.txt"));
            System.out.println("All children of John Doe (loaded from file):");
            for (Person child : loadedTree.getChildren(person1)) {
                System.out.println(child.getFullName());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
