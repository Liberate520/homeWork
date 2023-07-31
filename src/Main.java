import java.io.*;
import java.time.LocalDate;

public class Main {

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        //создал семью
        Human Igor = new Human("Igor", Gender.Мужской, null, null, "Irina", LocalDate.of(1977, 4, 6), null);
        Human Olga = new Human("Olga", Gender.Женский, null, null, "Irina", LocalDate.of(1978, 4, 6), null);
        Human Irina = new Human("Irina", Gender.Женский, Igor, Olga, "null", LocalDate.of(1999, 4, 6),null);


        // создал экземпляр FamilyTree
        FamilyTree family = new FamilyTree();

        // добавил семью в семейное древо
        family.familyAdd(Igor);
        family.familyAdd(Olga);
        family.familyAdd(Irina);

        //Сериализация в файл с помощью класса ObjectOutputStream
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(
                new FileOutputStream("person.out"));
        objectOutputStream.writeObject(Igor);
        objectOutputStream.writeObject(Olga);
        objectOutputStream.writeObject(Irina);
        objectOutputStream.close();

        // Востановление из файла с помощью класса ObjectInputStream
        ObjectInputStream objectInputStream = new ObjectInputStream(
                new FileInputStream("person.out"));
        Human papaRestored = (Human) objectInputStream.readObject();
        Human mamaRestored = (Human) objectInputStream.readObject();
        Human dochkaRestored = (Human) objectInputStream.readObject();
        objectInputStream.close();

        System.out.println("Before Serialize: " + "\n" + Igor + "\n" + Olga + "\n" + Irina);


    }


}
