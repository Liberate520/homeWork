import java.io.IOException;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException, ClassNotFoundException {

        FamilyTree family1 = new FamilyTree();

        family1.add(new Human("Иван", "Иванов", Gender.Male, "12.12.1978"));
        family1.add(new Human("Мария", "Иванова", Gender.Female, "12.11.1981"));
        family1.add(new Human("Ольга", "Иванова", Gender.Female, "11.11.2001",
                family1.getByName("Иван"), family1.getByName("Мария")));

        FamilyTree family2 = new FamilyTree();
        family2.add(new Human("Петр", "Иванов", Gender.Male, "01.11.1987"));
        family2.add(new Human("Ирина", "Иванова", Gender.Female, "21.01.1991"));
        family2.add(new Human("Семен", "Иванов", Gender.Male, "10.01.2016",
                family2.getByName("Петр"), family2.getByName("Ирина")));
        family2.add(new Human("Архип", "Иванов", Gender.Male, "31.03.2019",
                family2.getByName("Петр"), family2.getByName("Ирина")));


//        System.out.println(human1.getChild());

//        System.out.println(family1.getInfo());
//        System.out.println(family2.getInfo());

        System.out.println("the tree is recorded \n" + family1.getInfo());

        FileHandler handler = new FileHandler();
       // ((Writable) family1).save(handler);
//        handler.save(family1);
       // handler.save((Writable) family1);
        family1.save(family1.getHumanList());
        List<Human> list1 = new ArrayList<>();



       // FamilyTree family3 = (FamilyTree) handler.load();
        //System.out.println("the tree is loaded " + family3.getInfo());



    }
}
