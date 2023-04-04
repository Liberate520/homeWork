import famyilyTree.FamilyTree;
import human.Gender;
import human.Human;

public class Main {
    public static void main(String[] args) {
        FamilyTree tree = new FamilyTree();

        tree.add(new Human("Никита", Gender.Male));
        tree.add(new Human("Ольга", Gender.Female));
        tree.add(new Human("Станислав", Gender.Male, tree.getByName("Никита"), tree.getByName("Ольга")));
        tree.add(new Human("Нина", Gender.Female, tree.getByName("Никита"), tree.getByName("Ольга")));
        tree.add(new Human("Павел", Gender.Male));
        tree.add(new Human("Виктор", Gender.Male));
        tree.add(new Human("Елена", Gender.Female));
        tree.add(new Human("Валенитин", Gender.Male));
        tree.add(new Human("Алена", Gender.Female));
        tree.add(new Human("Валерий", Gender.Male, tree.getByName("Виктор"), tree.getByName("Елена")));

        System.out.println(tree.getInfo());
    }
}

