package classes.service;

import classes.familyTree.FamilyTree;

public class Service {

    static String pathToTreeFile = "src/tree.out";
    static FamilyTree tree = new FamilyTree();
    static FileGuide fileGuide = new FileGuide();

    public static void testInput() {
        TestInput.TestInput(tree);
    }

    public static void getTreeInfo() {
        System.out.println(tree.getInfo());
        System.out.println("Список содержит записей: " + tree.humanList.size());
    }

    public static void sortTreeByName() {
        tree.sortByName();
        System.out.println(tree.getInfo());
    }

    public static void sortTreeById() {
        tree.sortById();
        System.out.println(tree.getInfo());
    }

    public static void sortTreeByBrithDate() {
        tree.sortByBrithDate();
        System.out.println(tree.getInfo());
    }

    public static void saveTree() {
        fileGuide.save(tree, pathToTreeFile);
    }

    public static void readTree() {
        tree = (FamilyTree) fileGuide.read(pathToTreeFile);
    }

}
