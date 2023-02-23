import java.io.Serializable;
import java.io.*;
//import

public class FileHandler implements Writable, Serializable
{
    public void save(Serializable serializable, Object object) throws IOException {

        ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream("FamilyTree.out"));
        objectOutputStream.writeObject(object);
        objectOutputStream.close();

        System.out.println("Сохранили");
    }

    public Object read() throws IOException, ClassNotFoundException {
        ObjectInputStream objectInputStream = new ObjectInputStream(
                new FileInputStream("FamilyTree.out"));
        Object fTree = (Object) objectInputStream.readObject();
        objectInputStream.close();
        System.out.println("Восстановление прошло успешно");
        return fTree;
    }

    public void test(){}
}
