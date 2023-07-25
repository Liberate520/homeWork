package genealogy_tree.WriterAndReader;

import genealogy_tree.Human.*;


import java.io.*;


public class Sirealize implements Serializable {



        Human1 human1 = new Human1();
        Human2 human2 = new Human2();
        Human3 human3 = new Human3();


    public void ObjectOutputStream() throws IOException, ClassNotFoundException  {
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(
                new FileOutputStream("genealogy_tree.txt"));
        objectOutputStream.writeObject(human1);
        objectOutputStream.writeObject(human2);
        objectOutputStream.writeObject(human3);
        objectOutputStream.close();
        System.out.println("Before Serialize: " + "\n" + human1 + "\n" + human2 + "\n" + human3);
    }
    public void ObjectInputStream () throws IOException, ClassNotFoundException {
        ObjectInputStream  objectInputStream  = new ObjectInputStream(
                new FileInputStream("genealogy_tree.txt"));
        Human human1Restored = (Human) objectInputStream.readObject();
        Human human2Restored = (Human) objectInputStream.readObject();
        Human human3Restored = (Human) objectInputStream.readObject();
        objectInputStream.close();
        System.out.println("After Restored: " + "\n" + human1Restored + "\n" + human2Restored + "\n" + human3Restored);
    }
}
