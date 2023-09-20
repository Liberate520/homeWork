package L1;

import java.io.*;
import java.util.ArrayList;

public class FileHandler implements Serializable {

    //Сериализация в файл с помощью класса ObjectOutputStream
    public void savePeople(Family_tree people) throws IOException {
        System.out.println("Идёт сохранение");
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(
                new FileOutputStream("peopleOut2.txt"));
        System.out.println(people);
        objectOutputStream.writeObject(people.listOfPeople);
        objectOutputStream.close();
    }

    // Востановление из файла с помощью класса ObjectInputStream
    public void loadPeople(Family_tree people) throws IOException, ClassNotFoundException {
        System.out.println("Идёт загрузка");
        ObjectInputStream objectInputStream = new ObjectInputStream(
                new FileInputStream("peopleOut2.txt"));
        people.listOfPeople = (ArrayList<Human>) objectInputStream.readObject();
        System.out.println(people);
        objectInputStream.close();
    }
}
