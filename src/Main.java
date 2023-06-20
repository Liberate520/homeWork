import familytree.Tree;
import familytree.TreeService;
import human.Human;
import save.FileOperations;
import save.Save;

import java.io.*;


public class Main {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        String filePath = "test.txt";
        FileOperations fileOperations = new Save();



//        Tree tree = (Tree) fileOperations.read(filePath);
        familytree.Tree<Human> tree = new familytree.Tree<>();

        fileOperations.write(tree, filePath);

        System.out.println(tree.getInfo());

        TreeService treeSort = new TreeService(tree);
        treeSort.sortByAge();
        System.out.println(tree.getInfo());
        treeSort.sortByName();
        System.out.println(tree.getInfo());
        treeSort.sortById();
        System.out.println(tree.getInfo());




    }
    }
