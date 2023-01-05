package homeWorkSem1;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class SerializeHandler implements Serializable, Writeble {

    ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();


    /** Сериализация в файл с помощью класса ObjectOutputStream implements Writeble*/
    @Override
    public void save(Serializable serializable) throws IOException {
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream("person.out"));
        objectOutputStream.writeObject(serializable);
        objectOutputStream.close();
    }


    //* Востановление из файла с помощью класса ObjectInputStream implements Writeble*/
    @Override
    public FamilyTree read() throws IOException, ClassNotFoundException {
        ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream("person.out"));
        Human humanRestored = (Human) objectInputStream.readObject();
        FamilyTree tree = new FamilyTree();
        tree.add(humanRestored);
        objectInputStream.close();
        return tree;
    }


    /**Сериализация с помощью класса ByteArrayOutputStreamv*/
    public void saveSerializeByte(Human human) throws IOException {
        
        ObjectOutputStream objectOutputStream2 = new ObjectOutputStream(byteArrayOutputStream);
        objectOutputStream2.writeObject(human);
        objectOutputStream2.flush();
    }


    /**Восстановление с помощью класса ByteArrayInputStream */
    public Human readSerializeByte() throws IOException, ClassNotFoundException {
        ObjectInputStream objectInputStream2 = new ObjectInputStream(new ByteArrayInputStream(byteArrayOutputStream.toByteArray()));
        Human humanRestoredFromByte = (Human) objectInputStream2.readObject();
        objectInputStream2.close();
        return humanRestoredFromByte;
    }
}
