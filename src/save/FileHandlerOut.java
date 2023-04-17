package save;

import java.io.*;

public class FileHandlerOut implements Writeable{
    @Override
    public boolean save(Serializable serializable, String path){
        try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(path))){
            objectOutputStream.writeObject(serializable);
            return true;
        } catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public Serializable load(String path) {
        try(ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(path))){
            return (Serializable) objectInputStream.readObject();
        } catch (Exception e){
            e.printStackTrace();
            return null;
        }

    }

}
