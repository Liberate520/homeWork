import java.io.*;

/** сериализация и восстановление сериализуемых объектов */
public class FileHandler implements CapableOfPreserving, CapableOfRestore {

    @Override
    public Serializable read(String path) throws IOException, ClassNotFoundException{
        ObjectInputStream stream = new ObjectInputStream(new FileInputStream(path)); 
        Serializable object = (Serializable)stream.readObject();
        stream.close();
        return object;
    }
    @Override
    public void save(String path, Serializable object)throws IOException {
        try (ObjectOutputStream stream = new ObjectOutputStream(new FileOutputStream(path))) {
            stream.writeObject(object);
            stream.flush();
        }
    }    
}
