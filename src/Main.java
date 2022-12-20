import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        Human Sergey = new Human("Sergey", Human.Gender.Male, 65);
        Human Marina = new Human("Marina", Human.Gender.Female, 63);

        Human Ivan = new Human("Ivan", Human.Gender.Male, 45, Sergey);
        Human Olga = new Human("Olga", Human.Gender.Female, 41, Marina);
        Human Andrey = new Human("Andrey", Human.Gender.Male, 43, Sergey);

        Human Semen = new Human("Semen", Human.Gender.Male, 20, Ivan, Olga);
        Human Pavel = new Human("Pavel", Human.Gender.Male, 1, Andrey, Olga);

        Human Evgeniy = new Human("Evgeniy", Human.Gender.Male, 11, Sergey, Marina);

        List<Human> humans = Arrays.asList(Sergey, Marina, Ivan, Olga, Andrey, Semen, Pavel);

        FamilyTree testTree = new FamilyTree("Test", humans);

        testTree.addHuman(Evgeniy);

        System.out.print("Результаты поиска человека по имени: ");
        testTree.findByName("Ivan");

        System.out.print("Результаты поиска братьев и сестер человека: ");
        System.out.println(Andrey.getSistersBrothers());

        System.out.print("Результаты поиска всех детей человека: ");
        System.out.println(Andrey.getChildren());

        System.out.println();
        System.out.println(testTree);
    }
}