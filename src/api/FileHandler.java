package api;

import java.io.Serializable;
import java.io.*;
//import

public class FileHandler implements Writable, Serializable
{
    public String save(Object object) throws IOException {

        ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream("api.FamilyTree.out"));
        objectOutputStream.writeObject(object);
        objectOutputStream.close();

        return "Дерево сохранено!\r";
    }

    public Object read() throws IOException, ClassNotFoundException {
        ObjectInputStream objectInputStream = new ObjectInputStream(
                new FileInputStream("api.FamilyTree.out"));
        Object fTree = (Object) objectInputStream.readObject();
        objectInputStream.close();
        //System.out.println("Восстановление прошло успешно");
        return fTree;
    }

    public void test(){}
}
