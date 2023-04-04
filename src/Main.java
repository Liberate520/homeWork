import java.io.IOException;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException, ClassNotFoundException {

        FamilyTree tree = new FamilyTree();
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

        System.out.println("По имени");
        service.sortByName();
        for (Human human :
                tree) {
            System.out.println(human);
        }

        System.out.println("По дате рождения");
        service.sortByBirthday();
        for (Human human :
                tree) {
            System.out.println(human);
        }
        System.out.println("По индексу");
        service.sortById();
        for (Human human :
                tree) {
            System.out.println(human);
        }

//        System.out.println("По количеству детей");
//        service.sortByNumChild();
//        for (Human human :
//                tree) {
//            System.out.println(human);
//        }
        System.out.println();


//        family1.add(new Human(1,"Иван", "Иванов", Gender.Male, "12.12.1978"));
//        family1.add(new Human(2,"Мария", "Иванова", Gender.Female, "12.11.1981"));
//        family1.add(new Human(3, "Ольга", "Иванова", Gender.Female, "11.11.2001",
//                family1.getByName("Иван"), family1.getByName("Мария")));
//
//        FamilyTree family2 = new FamilyTree();
//        family2.add(new Human("Петр", "Иванов", Gender.Male, "01.11.1987"));
//        family2.add(new Human("Ирина", "Иванова", Gender.Female, "21.01.1991"));
//        family2.add(new Human(1,"Семен", "Иванов", Gender.Male, "10.01.2016",
//                family2.getByName("Петр"), family2.getByName("Ирина")));
//        family2.add(new Human(1,"Архип", "Иванов", Gender.Male, "31.03.2019",
//                family2.getByName("Петр"), family2.getByName("Ирина")));


//        System.out.println(human1.getChild());

//        System.out.println(family1.getInfo());
//        System.out.println(family2.getInfo());

        System.out.println("the tree is recorded \n" + tree.getInfo());

        FileHandler handler = new FileHandler();
       // ((Writable) family1).save(handler);
//        handler.save(family1);
       // handler.save((Writable) family1);
//        family1.save(family1.getHumanList());
//        List<Human> list1 = new ArrayList<>();





       // FamilyTree family3 = (FamilyTree) handler.load();
        //System.out.println("the tree is loaded " + family3.getInfo());



    }
}
