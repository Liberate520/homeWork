package faminly_tree;

import java.io.*;

public class SaveInFile implements Serializable{
    public void Save(String path/*количество элементов под запись и их тип*/) throws IOException, ClassNotFoundException{
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(path));
        objectOutputStream.writeObject(igor); //переменная типа Person
        objectOutputStream.close();
    }
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        //РЕАЛИЗОВАТЬ КАК МЕТОДЫ ЗАПИСИ И ВОССТАНОВЛЕНИЯ
        //ДЛЯ ЭТОГО КЛАССА СДЕЛАТЬ ИНТЕРФЕЙС, КОТОРЫЙ БУДЕТ ИСПОЛЬЗОВАТЬСЯ В ОСНОВНОМ ПРОГРАММЕ
        //Сериализация в файл с помощью класса ObjectOutputStream
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(
                new FileOutputStream("person.out"));
        objectOutputStream.writeObject(igor); //переменная типа Person
        objectOutputStream.writeObject(renat);
        objectOutputStream.close();

        // Востановление из файла с помощью класса ObjectInputStream
        ObjectInputStream objectInputStream = new ObjectInputStream(
                new FileInputStream("person.out"));
        Person igorRestored = (Person) objectInputStream.readObject(); //класс Person
        Person renatRestored = (Person) objectInputStream.readObject();
        objectInputStream.close();

        //Сериализация с помощью класса ByteArrayOutputStream
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        ObjectOutputStream objectOutputStream2 = new ObjectOutputStream(byteArrayOutputStream);
        objectOutputStream2.writeObject(igor);
        objectOutputStream2.writeObject(renat);
        objectOutputStream2.flush();

        //Восстановление с помощью класса ByteArrayInputStream
        ObjectInputStream objectInputStream2 = new ObjectInputStream(
                new ByteArrayInputStream(byteArrayOutputStream.toByteArray()));
        Person igorRestoredFromByte = (Person) objectInputStream2.readObject();
        Person renatRestoredFromByte = (Person) objectInputStream2.readObject();
        objectInputStream2.close();

        System.out.println("Before Serialize: " + "\n" + igor + "\n" + renat);
        System.out.println("After Restored From Byte: " + "\n" + igorRestoredFromByte + "\n" + renatRestoredFromByte);
        System.out.println("After Restored: " + "\n" + igorRestored + "\n" + renatRestored);
    }
}
