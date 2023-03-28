import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

public class Main {
    public static void main(String[] args) {
        human h_1 = new human("Иванов Иван Иванович", gender.male, 1968);
        human h_2 = new human("Иванова Мария Петровна", gender.female, 1970);
        human h_3 = new human("Петрова Екатерина Ивановна", gender.female, h_1, h_2, 1990);
        human h_4 = new human("Иванов Игорь Иванович", gender.male, h_1, h_2, 1998);
        human h_5 = new human("Петров Андрей Владимирович", gender.male, 1988);
        human h_6 = new human("Петрова София Андреевна", gender.female, h_5, h_3, 2012);
        human h_7 = new human("Петров Алексей Андреевич", gender.male, h_5, h_3, 2015);
        ArrayList<human> humans = new ArrayList<>(Arrays.asList(h_1, h_2, h_3, h_4, h_5, h_6, h_7));

        familyTree familyTree = new familyTree(humans);
        familyTree.checkAndAddChildren();
        System.out.println(familyTree);

        Iterator<human> iterator = familyTree.iterator();
        while (iterator.hasNext()) {
            human human = iterator.next();
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
