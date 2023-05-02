package tree;

public class Main {
    public static void main(String[] args) {
        FamilyTree tree = new FamilyTree();

        tree.add(new Human("Иван", Gender.MaLe));
        tree.add(new Human("Марина", Gender.FemaLe));
        tree.add(new Human("Сергей",Gender.MaLe, tree.getByName("Марина"), tree.getByName("Иван")));
        tree.add(new Human("Светлана",Gender.FemaLe, tree.getByName("Марина"), tree.getByName("Иван")));

        System.out.println(tree.getInfo());
    }
}
