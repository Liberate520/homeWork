import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Human h_1 = new Human("Кузнецов Иван Иванович", Gender.male, 1874);
        Human h_2 = new Human("Кузнецова Евдокия Петровна", Gender.female, 1881);
        Human h_3 = new Human("Грищенко Мария Ивановна", Gender.female, h_1, h_2, 1910);
        Human h_4 = new Human("Кузнецов Петр Иванович", Gender.male, h_1, h_2, 1924);
        Human h_5 = new Human("Грищенко Афонасий Ермолаевич", Gender.male, 1915);
        Human h_6 = new Human("Богданова Зоя Афонасьевна", Gender.female, h_5, h_3, 1937);
        Human h_7 = new Human("Грищенко Александр Афонасьевич", Gender.male, h_5, h_3, 1940);
        ArrayList<Human> humans = new ArrayList<Human>(Arrays.asList(h_1, h_2, h_3, h_4, h_5, h_6, h_7));

        FamilyTree familyTree = new FamilyTree();
        for (Human human : humans) {
            familyTree.addHuman(human);
        }

        System.out.println(familyTree);
        familyTree.printChildren();
    }
}
