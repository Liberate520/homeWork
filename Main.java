package homeWork;

import homeWork.familytree.Tree;
import homeWork.filehandling.FamilyTreeFileHandler;
import homeWork.filehandling.FileHandler;

import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        Tree tree = new Tree();

        // Adding members to the family tree

        // File handling
        FileHandler fileHandler = new FamilyTreeFileHandler();
        try {
            fileHandler.writeToFile(tree, "family_tree_data.txt");
            Tree restoredTree = fileHandler.readFromFile("family_tree_data.txt");
            System.out.println("Restored family tree data:");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}


