public class Test {
    public static void main(String[] args) {
        Person p1 = new Person("Александр", Gender.Male, null, null);
        Person p2 = new Person("Александра", Gender.Female, null, null);
        Person p3 = new Person("Олег", Gender.Male, p2, p1);
        Person p4 = new Person("Петр", Gender.Male, p2, p1);
        FamilyTree tree = new FamilyTree();
        tree.setPerson(p1, p2, p3, p4);
        // Демонстрация чтения и записи
        RecordTree<FamilyTree> recordTree = new RecordTree<>();
        recordTree.saveTree(tree, ".//src//SavedTrees//FamilyTree.bin");
        FamilyTree tree2 = (FamilyTree) recordTree.loadTree(".//src//SavedTrees//FamilyTree.bin");
        System.out.println(tree2.showAllTree());
        // Демонстрация методов взаимодействия с деревом
//        System.out.println(tree.showAllTree());
//        System.out.println(tree.getParents(p4));
//        System.out.println(tree.getBrothersAndSisters(p3));
//        System.out.println(tree.getChildren(p2));

    }
}
