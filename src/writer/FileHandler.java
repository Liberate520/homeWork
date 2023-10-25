package writer;

import human.Human;

import java.io.*;

//описание методов сохранения и загрузки
public class FileHandler implements Writable{


//    FileHandler fh = new FileHandler();
//    Human h = new Human();

//Сериализация в файл с помощью класса ObjectOutputStream
    public FileHandler(Human h) throws IOException, ClassNotFoundException {
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream("family.out"));
        objectOutputStream.writeObject(h);
        objectOutputStream.close();

        // Востановление из файла с помощью класса ObjectInputStream
        ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream("family.out"));
        Human hRestored = (Human) objectInputStream.readObject();
        objectInputStream.close();

    }


}
