package Input_output;

import java.io.*;

import members.Human;

abstract class FileHandler {
    ObjectOutputStream objectOutputStream = new ObjectOutputStream(
                new FileOutputStream("Human.out"));
        objectOutputStream.writeObject();
        objectOutputStream.close();
    ObjectInputStream objectInputStream = new ObjectInputStream(
                new FileInputStream("Human.out"));
        Human human1 = (Human) objectInputStream.readObject();
        objectInputStream.close();
}
