import java.io.*;
import java.util.Objects;


public class FileWorker implements Serializable {
    Person person;
    Tree tree;

    public FileWorker(Tree tree) {
        this.tree = tree;
    }
    public FileWorker(Person person) {
        this.person = person;
    }

    public static void SaveFile (Person person) {
        try(ObjectOutputStream data = new ObjectOutputStream(new FileOutputStream("Data.txt")))
        {
            data.writeObject(person.getInfo());
            System.out.println("File saved");
        }
        catch(Exception ex){
            System.out.println(ex.getMessage());
        }
    }

    public static void ReadFile (Person person) {
        try(ObjectInputStream data = new ObjectInputStream(new FileInputStream("Data.txt")))
        {
            Person p=(Person)data.readObject();
            System.out.println(p);
        }
        catch(Exception ex){
            System.out.println(ex.getMessage());
        }
    }

}
