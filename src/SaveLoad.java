import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Arrays;
import java.util.Scanner;

public class SaveLoad {

    public static void Load(FamilyTree familyTree) throws IOException, ClassNotFoundException {
        ObjectInputStream objectInputStream = new ObjectInputStream(
            new FileInputStream("FamilyTree.out"));
        Person person1 = (Person) objectInputStream.readObject();
        Person person2 = (Person) objectInputStream.readObject();
        Person person3 = (Person) objectInputStream.readObject();
        Person person4 = (Person) objectInputStream.readObject();
        objectInputStream.close();
        System.out.println(person1);
        System.out.println(person2);
        System.out.println(person3);
        System.out.println(person4);
    }

    public static void Write(FamilyTree familyTree) throws IOException, ClassNotFoundException {

        ObjectOutputStream objectOutputStream = new ObjectOutputStream(
            new FileOutputStream("FamilyTree.out"));
        objectOutputStream.writeObject(Main.person1);
        objectOutputStream.writeObject(Main.person2);
        objectOutputStream.writeObject(Main.person3);
        objectOutputStream.writeObject(Main.person4);
        objectOutputStream.close();
    }
}
