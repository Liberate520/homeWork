package family_tree;

import family_tree.iu.BaseUI;
import family_tree.iu.ConsoleUI;


public class Main {
    public static void main(String[] args) {

        BaseUI baseUI = new ConsoleUI();
        baseUI.start();
/*
        String filePath = "src/family_tree/dump/family_tree.dump";

        FileHandler fileHandler = new FileHandler();
        System.out.println("=========================");

        if (new File(filePath).isFile()){
            FamilyTree familyTree = (FamilyTree) fileHandler.readDump(filePath);
//            familyTree.sortByBirthDays();
            System.out.println("FamilyTree from the DUMP:");
            System.out.println("=========================");
            System.out.println(familyTree.getFullRelativesInfo()); // Full of Persons list, but not full for Person tree
            System.out.println(":::::::::::: Personal FamilyTree for person#id ::::::::::::");
            System.out.println(familyTree.getPersonalTree(3)); // prepared for printing selected tree (by Person ID)
        } else {
            System.out.println("Save FamilyTree for preview:");
            System.out.println("=========================");
            FamilyTree familyTree = Preview.makePreviewTree();
//            familyTree.sortByNames();
            System.out.println(familyTree.getFullRelativesInfo()); // Full of Persons list, but not full for Person tree
            System.out.println(":::::::::::: Personal FamilyTree for person#id ::::::::::::");
            System.out.println(familyTree.getPersonalTree(3)); // prepared for printing selected tree (by Person ID)
            fileHandler.saveDump(familyTree, filePath);
        }
*/
    }

}