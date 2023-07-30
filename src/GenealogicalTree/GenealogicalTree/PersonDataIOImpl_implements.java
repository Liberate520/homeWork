package GenealogicalTree;


import java.io.*;
import java.util.*;

public class PersonDataIOImpl_implements implements PersonDataIO {
    @Override
    public void writeData(List<Person> people, String filename) throws IOException {
        ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(filename));
        outputStream.writeObject(people);
        outputStream.close();
        System.out.println("Данные успешно записаны в файл.");
    }

    @Override
    public List<Person> readData(String filename) throws IOException {
        List<Person> people = new ArrayList<>();
        ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(filename));
        try {
            people = (List<Person>) inputStream.readObject();
        } catch (ClassNotFoundException e) {
            System.out.println("Ошибка при чтении данных из файла.");
        }
        inputStream.close();
        return people;
    }
}
