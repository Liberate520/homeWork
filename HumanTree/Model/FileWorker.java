package Model;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class FileWorker implements Serializable {
    
    public void write(Object obj) throws IOException, ClassNotFoundException{
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(
                new FileOutputStream("human.txt"));
        objectOutputStream.writeObject(obj);        
        objectOutputStream.close();
        System.out.println("Запись прошла успешно");
    }
    
    public Object read() throws IOException, ClassNotFoundException{
        ObjectInputStream objectInputStream = new ObjectInputStream(
                new FileInputStream("human.txt"));
        Object obj = (Object) objectInputStream.readObject();        
        objectInputStream.close();
        System.out.println("Чтение прошло успешно");
        return obj;
    }
}
