import famyilyTree.FamilyTree;
import famyilyTree.Serial;
import human.Gender;
import human.Human;

public class Main {
    public static void main(String[] args) {
        String filename = "data.txt";
        FamilyTree tree = new FamilyTree();
        Serial serial = new Serial();

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

        // Сериализация
        serial.saveToFile(tree, filename);

        // Десериализация
        FamilyTree tree2 = serial.loadFromFile(filename);

        System.out.println(tree2.getInfo());
        System.out.println(tree.equals(tree2));
    }
}

