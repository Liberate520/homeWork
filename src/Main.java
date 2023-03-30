
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

public class Main {
    public static void main(String[] args) {
        Human h_1 = new Human("Иванов Иван Иванович", Gender.male, 1968);
        Human h_2 = new Human("Иванова Мария Петровна", Gender.female, 1970);
        Human h_3 = new Human("Петрова Екатерина Ивановна", Gender.female, h_1, h_2, 1990);
        Human h_4 = new Human("Иванов Игорь Иванович", Gender.male, h_1, h_2, 1998);
        Human h_5 = new Human("Петров Андрей Владимирович", Gender.male, 1988);
        Human h_6 = new Human("Петрова София Андреевна", Gender.female, h_5, h_3, 2012);
        Human h_7 = new Human("Петров Алексей Андреевич", Gender.male, h_5, h_3, 2015);
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
                System.out.printf("%s (%d) имеет детей:\n %s\n ", human.getFullName(), human.getBirthYear(),
                    human.getChildren());
            }
        }
        System.out.println(familyTree.getHumanByName("Иванов Иван Иванович"));
    }
}
