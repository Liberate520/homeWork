import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.List;

public class Save implements Serializable{
    @Override
    public void voice(List<Person> humanList) throws IOException {
        //Сериализация в файл с помощью класса ObjectOutputStream
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(
                new FileOutputStream("person.out"));
        for (Person p : humanList) {
            objectOutputStream.writeObject(p);
        }
        System.out.println("Генеалогическое древо Романовых успешно сохранено");
        objectOutputStream.close();

    }
}
