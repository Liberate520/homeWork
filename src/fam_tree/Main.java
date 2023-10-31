package fam_tree;


public class Main {
    public static void main(String[] args) {
        FamilyTree tree = testTree();
        System.out.println(tree);

    }

    static FamilyTree testTree() {
        FamilyTree tree = new FamilyTree();

        Human vasya = new Human("Vasya", Gender.Male);

        tree.add(vasya);
        Human masha = new Human("masha", Gender.Female);
        tree.add(masha);
        Human children = new Human("Vasya", Gender.Male);
        tree.add(children);
        Human semyon = new Human("Vasya", Gender.Male);
        tree.add(semyon);


        return tree;
    }


}
