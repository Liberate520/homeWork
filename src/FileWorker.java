import java.io.*;

public class FileWorker implements Writable {
    public void saveToFile( Serializable obj, String filePath )
    {
        try {
            //Сериализация в файл с помощью класса ObjectOutputStream
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(
                    new FileOutputStream(filePath));
            objectOutputStream.writeObject( obj );
            objectOutputStream.close();
            System.out.println("Успешно записано в файл.");
        }
        catch ( Exception e )
        {
            System.out.println("Запись в файл не удалась.");
        }
    }
    public Object readFromFile( String filePath )
    {
        try {
            // Востановление из файла с помощью класса ObjectInputStream
            ObjectInputStream objectInputStream = new ObjectInputStream(
                    new FileInputStream( filePath ));
            Object obj = (Object) objectInputStream.readObject();
            objectInputStream.close();
            System.out.println("Успешно записано в файл.");
            return obj;
        }
        catch ( Exception e )
        {
            System.out.println("Запись в файл не удалась.");
            return null;
        }
    }

}
