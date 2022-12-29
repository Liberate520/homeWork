import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {

//        UserMenu menu = new UserMenu();
//        menu.startMenu();


//        ______________________________________________________________________
//        люди

        Human Sergey = new Human("Sergey", Human.Gender.Male, 65);
        Human Marina = new Human("Marina", Human.Gender.Female, 63);

        Human Ivan = new Human("Ivan", Human.Gender.Male, 45, Sergey);
        Human Olga = new Human("Olga", Human.Gender.Female, 41, Marina);
        Human Andrey = new Human("Andrey", Human.Gender.Male, 43, Sergey);

        Human Semen = new Human("Semen", Human.Gender.Male, 20, Ivan, Olga);
        Human Pavel = new Human("Pavel", Human.Gender.Male, 1, Andrey, Olga);

        Human Evgeniy = new Human("Evgeniy", Human.Gender.Male, 11, Sergey, Marina);

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

        System.out.print("Результаты сортировки по имени: \n");
        Service.sortByName(humanTree);
        System.out.println(humanTree);
        System.out.println("---");

        System.out.print("Результаты сортировки по возрасту: \n");
        Service.sortByAge(humanTree);
        System.out.println(humanTree);
        System.out.println("---");

//        ______________________________________________________________________
//        коты

        Cat Vasiliy = new Cat("Vasiliy", Cat.Gender.Male, 65);
        Cat Murka = new Cat("Murka", Cat.Gender.Female, 63);

        Cat Rizhik = new Cat("Rizhik", Cat.Gender.Male, 45, Vasiliy);
        Cat Elli = new Cat("Elli", Cat.Gender.Female, 41, Murka);
        Cat Dimok = new Cat("Dimok", Cat.Gender.Male, 43, Vasiliy);

        Cat Murzik = new Cat("Murzik", Cat.Gender.Male, 20, Rizhik, Elli);
        Cat Mur = new Cat("Mur", Cat.Gender.Male, 1, Dimok, Elli);

        Cat Murz = new Cat("Murz", Cat.Gender.Male, 11, Vasiliy, Murka);

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
        Service.sortByName(catsTree);
        System.out.println(catsTree);
        System.out.println("---");

        System.out.print("Результаты сортировки по возрасту: \n");
        Service.sortByAge(catsTree);
        System.out.println(catsTree);
        System.out.println("---");
    }
}