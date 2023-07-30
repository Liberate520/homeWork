package family_tree;

import java.io.File;
import family_tree.dump_file.FileHandler;
import family_tree.person.Person;
import family_tree.service.previewGenerator;
import family_tree.ftree.FamilyTree;


public class Main {
    public static void main(String[] args) {
        String filePath = "src/family_tree/dump/family_tree.dump";

        FileHandler fileHandler = new FileHandler();
        System.out.println("=========================");

        if (new File(filePath).isFile()){
            FamilyTree<Person> familyTree = (FamilyTree) fileHandler.readDump(filePath);
            System.out.println("FamilyTree from the DUMP:");
            System.out.println("=========================");
            familyTree.sortByBirthDays();
            System.out.println(familyTree.getFullRelativesInfo()); // Full of Persons list, but not full for Person tree
            System.out.println(":::::::::::: Personal FamilyTree for person#id ::::::::::::");
            System.out.println(familyTree.getPersonalTree(3)); // prepared for printing selected tree (by Person ID)
        } else {
            System.out.println("Save FamilyTree for preview:");
            System.out.println("=========================");
            FamilyTree<Person> familyTree = previewGenerator.previewTree();
            familyTree.sortByNames();
            System.out.println(familyTree.getFullRelativesInfo()); // Full of Persons list, but not full for Person tree
            System.out.println(":::::::::::: Personal FamilyTree for person#id ::::::::::::");
            System.out.println(familyTree.getPersonalTree(3)); // prepared for printing selected tree (by Person ID)
            fileHandler.saveDump(familyTree, filePath);
        }

    }

}