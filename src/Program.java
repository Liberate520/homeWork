import java.io.*;
import java.time.LocalDate;


public class Program implements Serializable{

    public Program() throws IOException, ClassNotFoundException {
    }

    public static void main(String[] args)  throws IOException, ClassNotFoundException {
        FamilyTree myTree =new FamilyTree();

        Human human1 = new Human ("Андрей", "Шевцов", Gender.Male,LocalDate.of(1915, 1, 14), LocalDate.of(1959, 01, 13));
        Human human2 = new Human("Анатолий", "Шевцов", Gender.Male,LocalDate.of(1931, 2, 19), LocalDate.of(1976, 01, 11));
        Human human3 = new Human("Татьяна", "Квашина", Gender.Female,LocalDate.of(1922, 4, 19), LocalDate.of(1970, 01, 13));
        Human human4 = new Human("Виктор", "Зайцев", Gender.Male, LocalDate.of(1975, 8, 05));
        Human human5 = new Human("Станислав", "Петров", Gender.Male, LocalDate.of(1985, 9, 11));
        Human human6 = new Human("Юлия", "Скворцова", Gender.Female,LocalDate.of(1912, 4, 19), LocalDate.of(1968, 01, 19));



        human2.addMother(human6);
        human2.addChild(human4);

        myTree.addHumanToTree(human1);
        myTree.addHumanToTree(human2);
        myTree.addHumanToTree(human3);
        myTree.addHumanToTree(human4);
        myTree.addHumanToTree(human5);
        myTree.addHumanToTree(human6);



        //System.out.println(myTree.getInfo());
        System.out.println(human2.getFatherInfo());
        System.out.println(human2.getMotherInfo());
        System.out.println(human2.getChildrenInfo());

        //Сохраняем во внешний файл
        FileHandler handler = new FileHandler();
        handler.save(human2);

        //Загрузка, каст и чтение из файла
        Human test = (Human)handler.read();
        System.out.println("\nДанные загружены из файла: " + test.getInfoHuman());

    }
}
