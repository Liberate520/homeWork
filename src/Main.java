import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.time.LocalDate;

import familyTree.famTree.FamilyTree;
import human.Gender;
import human.Human;

public class Main {
    public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException {
        FamilyTree myFamilyTree = new FamilyTree(123);

        Human human_1 = new Human("Иван", "Пупкин", LocalDate.of(1955,5,5));
        Human human_2 = new Human("Петр", "Глобусов",  LocalDate.of(1944,4,4), Gender.Male);
        Human human_3 = new Human("Виктор", "Лопатов",  LocalDate.of(1933,3,3), Gender.Male);
        Human human_4 = new Human("Бушар", "Комбарович",  LocalDate.of(1922,2,2), Gender.Male);
        Human human_5 = new Human("Анастасия", "Загоняева",  LocalDate.of(1911,1,1), 
            LocalDate.of(1988,8,8), Gender.Femala);

        myFamilyTree.addHuman(human_1);
        myFamilyTree.addHuman(human_2);
        myFamilyTree.addHuman(human_3);
        myFamilyTree.addHuman(human_4);
        myFamilyTree.addHuman(human_5);

        ObjectOutputStream objectOutputStream = new ObjectOutputStream(
                new FileOutputStream("human.out"));
        objectOutputStream.writeObject(human_1);
        objectOutputStream.close();

        ObjectInputStream objectInputStream = new ObjectInputStream(
                new FileInputStream("human.out"));
        Human human_1Restored = (Human) objectInputStream.readObject();
        objectInputStream.close();

        System.out.println(myFamilyTree.getHumansInfo());
        System.out.println("До сериализации: " + "\n" + human_1);
        System.out.println("После сериализации: " + "\n" + human_1Restored);
    }
}