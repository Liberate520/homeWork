import familyTree.FamilyTree;
import human.Gender;
import human.Human;
import service.FileHandler;

public class Main {
    public static void main(String[] args) {

        FamilyTree<Human> tree = new FamilyTree<Human>();
        Service service = new Service(tree);
        service.addHuman("Иван", "Иванов", Gender.Male, "12.12.1978");
        service.addHuman("Мария", "Иванова", Gender.Female, "12.11.1981");
        service.addHuman("Ольга", "Иванова", Gender.Female, "11.11.2001",
                tree.getByName("Иван"), tree.getByName("Мария"));

        service.addHuman("Петр", "Иванов", Gender.Male, "01.11.1987");
        service.addHuman("Ирина", "Иванова", Gender.Female, "21.01.1991");
        service.addHuman("Семен", "Иванов", Gender.Male, "10.01.2016",
                tree.getByName("Петр"), tree.getByName("Ирина"));
        service.addHuman("Архип", "Иванов", Gender.Male, "31.03.2019",
                tree.getByName("Петр"), tree.getByName("Ирина"));

        System.out.println("По имени: ");
        service.sortByName();
        for (Human human : tree) System.out.println(human);

        System.out.println("По дате рождения: ");
        service.sortByBirthday();
        for (Human human :
                tree) {
            System.out.println(human);
        }
        System.out.println("По количеству детей: ");
        service.sortByNumChild();
        for (Human human :
                tree) {
            System.out.println(human);
        }
        System.out.println();
        /*
 TODO
        System.out.println("По индексу: ");
        service.sortById();
        for (Human human :
                tree) {
            System.out.println(human);
        }
*/
        service.printHumanList();

        System.out.println("дерево перед записью\n" + tree.getInfo());

        service.setHandler(new FileHandler());
        // организация записи через сервис
        service.save("src/out.dat");
        // организация чтения через сервис
        service.load("src/out.dat");

        System.out.println("дерево прочитано из файла\n" + tree.getInfo());


//




       // FamilyTree family3 = (FamilyTree) handler.load();
        //System.out.println("the tree is loaded " + family3.getInfo());



    }
}
