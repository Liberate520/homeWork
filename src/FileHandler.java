import java.io.*;

public class FileHandler implements SaveLoad {
    //Этот класс выполняет сохранение в файл и загрузку из файла

    public void saveTo(Object obj, String path) throws IOException {
        //Сериализация в файл с помощью класса ObjectOutputStream
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(
                new FileOutputStream(path));
        objectOutputStream.writeObject(obj);
        objectOutputStream.close();
    }

    public Object loadFrom(String path) throws IOException, ClassNotFoundException {
        // Востановление из файла с помощью класса ObjectInputStream
        ObjectInputStream objectInputStream = new ObjectInputStream(
                new FileInputStream(path));
        Object result = objectInputStream.readObject();
        objectInputStream.close();
        return result;
    }
}
