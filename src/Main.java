public class Main {
    public static void main(String[] args) {
        FamilyTree tree = new FamilyTree();
        Utils utils = new Utils(tree);

        Human human1 = tree.addHuman("Алексей", "Иванов");
        Human human2 = tree.addHuman("Алина", "Петрова");
        Human human3 = tree.addHuman("Андрей", "Иванов");

        tree.addRelation(new Relation(human1.id, human2.id, Relation.Node.MARIAGE));
        tree.addRelation(new Relation(human1.id, human3.id, Relation.Node.CHILD));
        tree.addRelation(new Relation(human2.id, human3.id, Relation.Node.CHILD));

        System.out.println(tree.getHumans());
        System.out.println(tree.getRelations());
    }
}