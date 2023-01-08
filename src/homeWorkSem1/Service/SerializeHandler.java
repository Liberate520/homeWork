package homeWorkSem1.Service;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

import homeWorkSem1.FamilyTree;
import homeWorkSem1.Human;

public class SerializeHandler<T extends FamilyTree<Human> > implements Serializable, Writeble<T> {

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
    public T read() throws IOException, ClassNotFoundException {
        ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream("person.out"));
        T humanRestored = (T) objectInputStream.readObject();//что-то не так
        objectInputStream.close();
        return humanRestored;
    }


    /**Сериализация с помощью класса ByteArrayOutputStreamv*/
    public void saveSerializeByte(T t) throws IOException {
        ObjectOutputStream objectOutputStream2 = new ObjectOutputStream(byteArrayOutputStream);
        objectOutputStream2.writeObject(t);
        objectOutputStream2.flush();
    }


    /**Восстановление с помощью класса ByteArrayInputStream */
    public T readSerializeByte() throws IOException, ClassNotFoundException {
        ObjectInputStream objectInputStream2 = new ObjectInputStream(new ByteArrayInputStream(byteArrayOutputStream.toByteArray()));
        T humanRestoredFromByte = (T) objectInputStream2.readObject();//что-то не так
        objectInputStream2.close();
        return humanRestoredFromByte;
    }
}
