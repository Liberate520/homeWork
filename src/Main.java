import java.time.LocalDate;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Human mikhail = new Human(Gender.MALE, LocalDate.of(1984, 6, 6), null, null);
        Human ekaterina = new Human(Gender.FEMALE, LocalDate.of(1987, 7, 18), null, null);
        Human kirill = new Human(Gender.MALE, LocalDate.of(2008, 12, 25), mikhail, ekaterina);
        Human elizaveta = new Human(Gender.FEMALE, LocalDate.of(2016, 8, 19), mikhail, ekaterina);

        mikhail.addChild(kirill);
        mikhail.addChild(elizaveta);
        ekaterina.addChild(kirill);
        ekaterina.addChild(elizaveta);

        Node rootNode = new Node(mikhail, null, null);
        FamilyTree familyTree = new FamilyTree(rootNode);

        // Дальше можно использовать методы класса FamilyTree для работы с древом
        List<Human> allChildren = familyTree.getAllChildren(mikhail);
        for (Human child : allChildren) {
            System.out.println(child);
        }
    }
}