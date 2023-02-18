import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.List;

public class Restore implements Serializable{
    @Override
    public void voice(List<Person> humanList) throws IOException, ClassNotFoundException {
        // Востановление из файла с помощью класса ObjectInputStream
        ObjectInputStream objectInputStream = new ObjectInputStream(
                new FileInputStream("person.out"));
        System.out.println("---------------------------------------------------");
        System.out.println("Сохраненный список гениалогического древа Романовых");
        System.out.println("---------------------------------------------------");
       for (int i = 1; i <= 41; i++) {
           Person pRestored = (Person) objectInputStream.readObject();
           System.out.println(pRestored);
           System.out.println("------------------------------------------------");
       }
        objectInputStream.close();

    }
}
