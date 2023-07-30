import java.io.*;
import java.time.LocalDate;

public class Main {

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        //создал семью
        Human papa = new Human("Igor", Gender.Мужской, null, null, "Irina", LocalDate.of(1977, 4, 6));
        Human mama = new Human("Olga", Gender.Женский, null, null, "Irina", LocalDate.of(1978, 4, 6));
        Human dochka = new Human("Irina", Gender.Мужской, "Igor", "olga", "null", LocalDate.of(1999, 4, 6));


        // создал экземпляр FamilyTree
        FamilyTree family = new FamilyTree();

        // добавил семью в семейное древо
        family.familyAdd(papa);
        family.familyAdd(mama);
        family.familyAdd(dochka);

        //Сериализация в файл с помощью класса ObjectOutputStream
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(
                new FileOutputStream("person.out"));
        objectOutputStream.writeObject(papa);
        objectOutputStream.writeObject(mama);
        objectOutputStream.writeObject(dochka);
        objectOutputStream.close();

        // Востановление из файла с помощью класса ObjectInputStream
        ObjectInputStream objectInputStream = new ObjectInputStream(
                new FileInputStream("person.out"));
        Human papaRestored = (Human) objectInputStream.readObject();
        Human mamaRestored = (Human) objectInputStream.readObject();
        Human dochkaRestored = (Human) objectInputStream.readObject();
        objectInputStream.close();

        System.out.println("Before Serialize: " + "\n" + papa + "\n" + mama + "\n" + dochka);


    }


}
