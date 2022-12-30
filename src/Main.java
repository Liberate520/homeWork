import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {

//        UserMenu menu = new UserMenu();
//        menu.startMenu();


//        ______________________________________________________________________
//        люди

        Human Sergey = new Human("Sergey", Gender.Male, 65);
        Human Marina = new Human("Marina", Gender.Female, 63);

        Human Ivan = new Human("Ivan", Gender.Male, 45, Sergey);
        Human Olga = new Human("Olga", Gender.Female, 41, Marina);
        Human Andrey = new Human("Andrey", Gender.Male, 43, Sergey);

        Human Semen = new Human("Semen", Gender.Male, 20, Ivan, Olga);
        Human Pavel = new Human("Pavel", Gender.Male, 1, Andrey, Olga);

        Human Evgeniy = new Human("Evgeniy", Gender.Male, 11, Sergey, Marina);

        List<Human> humans = Arrays.asList(Sergey, Marina, Ivan, Olga, Andrey, Semen, Pavel);

        FamilyTree<Human> humanTree = new FamilyTree("humans", humans);
        humanTree.addElement(Evgeniy);

        System.out.print("Результаты поиска человека по имени: ");
        humanTree.findByName("Ivan");
        System.out.println("---");

        System.out.print("Результаты поиска братьев и сестер человека: ");
        System.out.println(Andrey.getSistersBrothers());
        System.out.println("---");

        System.out.print("Результаты поиска всех детей человека: ");
        System.out.println(Andrey.getChildren());
        System.out.println("---");

        System.out.print("Результаты вывода всего дерева: ");
        System.out.println();
        System.out.println(humanTree);
        System.out.println("---");

        System.out.print("Результаты работы с чтением и записью: \n");
        FileWorker worker = new FileWorker();
        humanTree.setWritable(worker);

        humanTree.save();
        System.out.printf("\n%s\n",humanTree.read());
        humanTree.save();
        System.out.println("---");

        System.out.print("Результаты вывода элементов дерева через итератор: \n");
        for (Human hum : humanTree) {
            System.out.println(hum);
        }
        System.out.println("---");

        Service service = new Service();

        System.out.print("Результаты сортировки по имени: \n");
        service.sortByName(humanTree);
        System.out.println(humanTree);
        System.out.println("---");

        System.out.print("Результаты сортировки по возрасту: \n");
        service.sortByAge(humanTree);
        System.out.println(humanTree);
        System.out.println("---");

//        ______________________________________________________________________
//        коты

        Cat Vasiliy = new Cat("Vasiliy", Gender.Male, 65);
        Cat Murka = new Cat("Murka", Gender.Female, 63);

        Cat Rizhik = new Cat("Rizhik", Gender.Male, 45, Vasiliy);
        Cat Elli = new Cat("Elli", Gender.Female, 41, Murka);
        Cat Dimok = new Cat("Dimok", Gender.Male, 43, Vasiliy);

        Cat Murzik = new Cat("Murzik", Gender.Male, 20, Rizhik, Elli);
        Cat Mur = new Cat("Mur", Gender.Male, 1, Dimok, Elli);

        Cat Murz = new Cat("Murz", Gender.Male, 11, Vasiliy, Murka);

        List<Cat> cats = Arrays.asList(Vasiliy, Murka, Rizhik, Elli, Dimok, Murzik, Mur);

        FamilyTree<Cat> catsTree = new FamilyTree("cats", cats);

        catsTree.addElement(Murz);

        System.out.print("Результаты поиска кота по имени: ");
        catsTree.findByName("Murka");
        System.out.println("---");

        System.out.print("Результаты поиска братьев и сестер кота: ");
        System.out.println(Dimok.getSistersBrothers());
        System.out.println("---");

        System.out.print("Результаты поиска всех детей кота: ");
        System.out.println(Vasiliy.getChildren());
        System.out.println("---");

        System.out.print("Результаты вывода всего дерева: ");
        System.out.println();
        System.out.println(catsTree);
        System.out.println("---");

        System.out.print("Результаты работы с чтением и записью: \n");
        catsTree.setWritable(worker);

        catsTree.save();
        System.out.printf("\n%s\n",catsTree.read());
        catsTree.save();
        System.out.println("---");

        System.out.print("Результаты вывода элементов дерева через итератор: \n");
        for (Cat cat : catsTree) {
            System.out.println(cat);
        }
        System.out.println("---");

        System.out.print("Результаты сортировки по имени: \n");
        service.sortByName(catsTree);
        System.out.println(catsTree);
        System.out.println("---");

        System.out.print("Результаты сортировки по возрасту: \n");
        service.sortByAge(catsTree);
        System.out.println(catsTree);
        System.out.println("---");
    }
}