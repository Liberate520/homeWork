import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Human h_1 = new Human("Кузнецов Иван Иванович", Gender.male, 1874);
        Human h_2 = new Human("Кузнецова Евдокия Петровна", Gender.female, 1881);
        Human h_3 = new Human("Грищенко Мария Ивановна", Gender.female, h_1, h_2, 1910);
        Human h_4 = new Human("Кузнецов Петр Иванович", Gender.male, h_1, h_2, 1924);
        Human h_5 = new Human("Грищенко Афонасий Ермолаевич", Gender.male, 1915);
        Human h_6 = new Human("Богданова Зоя Афонасьевна", Gender.female, h_5, h_3, 1937);
        Human h_7 = new Human("Грищенко Александр Афонасьевич", Gender.male, h_5, h_3, 1940);
        ArrayList<Human> humans = new ArrayList<>(Arrays.asList(h_1, h_2, h_3, h_4, h_5, h_6, h_7));

        FamilyTree familyTree = new FamilyTree(humans);
        familyTree.checkAndAddChildren();
        System.out.println(familyTree);

        Iterator<Human> iterator = familyTree.iterator();
        while (iterator.hasNext()) {
            Human human = iterator.next();
            if (human.getChildren().isEmpty()) {
                System.out.printf("%s (%d) не имеет детей!\n ", human.getFullName(), human.getBirthYear());
            } else {
                System.out.printf("%s (%d) имеет детей:\n %s\n", human.getFullName(), human.getBirthYear(), human.getChildren());
            }
        }

        System.out.println(familyTree.getHumanByName("Кузнецов Иван Иванович"));

    }
}