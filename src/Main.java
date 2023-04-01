import java.io.IOException;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException, ClassNotFoundException {

        FamilyTree family1 = new FamilyTree();

        Human human1 = new Human("Иван", "Иванов", Gender.Male, "12.12.1978");
        Human human2 = new Human("Мария", "Иванова", Gender.Female, "12.11.1981");
        Human human3 = new Human("Ольга", "Иванова", Gender.Female, "11.11.2001");
        family1.addHuman(human1); family1.addHuman(human2);
        family1.addHuman(human3); human3.setFather(human1);
        human3.setMother(human2); human1.addChild(human3);
        human2.addChild(human3);


        FamilyTree family2 = new FamilyTree();
        Human human4 = new Human("Петр", "Иванов", Gender.Male, "01.11.1987");
        Human human5 = new Human("Ирина", "Иванова", Gender.Female, "21.01.1991");
        Human human6 = new Human("Семен", "Иванов", Gender.Male, "10.01.2016");
        Human human7 = new Human("Архип", "Иванов", Gender.Male, "31.03.2019");
        family2.addHuman(human4);
        family2.addHuman(human5);
        family2.addHuman(human6);
        family2.addHuman(human7);
        human6.setFather(human4); human7.setFather(human4);
        human6.setMother(human5); human7.setMother(human5);
        human4.addChild(human6); human4.addChild(human7);
        human5.addChild(human6); human5.addChild(human7);

//        System.out.println(human1.getChild());
//        System.out.println(human2.getChild());
//        System.out.println(human4.getChild());
//        System.out.println(human5.getChild());

//        System.out.println(family1.getInfo());
//        System.out.println(family2.getInfo());

        System.out.println("the tree is recorded " + family1.getInfo());

        FileHandler handler = new FileHandler();
        handler.save(family1);

        FamilyTree family3 = (FamilyTree) handler.load();
        System.out.println("the tree is loaded " + family3.getInfo());



    }
}
