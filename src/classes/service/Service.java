package classes.service;

import classes.familyTree.FamilyTree;

public class Service {

    static String pathToTreeFile = "src/tree.out";
    static FamilyTree tree = new FamilyTree();
    static FileGuide fileGuide = new FileGuide();

    public static void TestInput() {
        TestInput.TestInput(tree);
    }

    public static void getTreeInfo() {
        System.out.println(tree.getInfo());
        System.out.println("Список содержит записей: " + tree.humanList.size());
    }

    public static void SortTreeByName() {
        tree.sortByName();
        System.out.println(tree.getInfo());
    }

    public static void SortTreeById() {
        tree.sortById();
        System.out.println(tree.getInfo());
    }

    public static void SortTreeByBrithDate() {
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
