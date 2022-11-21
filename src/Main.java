
public class Main {
    public static void main(String[] args) {

        FamilyTree tree = new FamilyTree();

        Human h1 = new Human("Человек1", 25);
        tree.treeHuman.add(h1);
        Human h2 = new Human("Человек2", 5);
        tree.treeHuman.add(h2);
        Human h3 = new Human("Человек3", 4);
        tree.treeHuman.add(h3);

        h1.addСommunications(h2, 1, 2);
        h1.addСommunications(h3, 1, 2);

        h1.printRelatives(2);

        tree.preOrder(h1, "");

    }
}
