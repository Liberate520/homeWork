import java.io.*;

public class FileHandler implements SaveLoad, Serializable {
    //Этот класс выполняет сохранение в файл и загрузку из файла

    public void SaveTo(Object obj, Object[] s) throws IOException {
        //Сериализация в файл с помощью класса ObjectOutputStream
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(
                new FileOutputStream(s[0].toString()));
        objectOutputStream.writeObject(obj);
        objectOutputStream.close();
    }

    public Object LoadFrom(Object[] s) throws IOException, ClassNotFoundException {
        // Востановление из файла с помощью класса ObjectInputStream
        ObjectInputStream objectInputStream = new ObjectInputStream(
                new FileInputStream(s[0].toString()));
        Object result = objectInputStream.readObject();
        objectInputStream.close();
        return result;
    }
}
