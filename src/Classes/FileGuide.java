package Classes;

import java.io.*;

public class FileGuide implements Writable{

    @Override
    public boolean save(Serializable serializable, String filePath) {
        try(ObjectOutputStream objectOutputStream=new ObjectOutputStream(new FileOutputStream(filePath))){
            objectOutputStream.writeObject(serializable);
            return true;
        } catch (IOException e) {
            //   throw new RuntimeException(e);
            e.printStackTrace();
            return false;
        }
    }

    public Object read(String filePath){
        try(ObjectInputStream objectInputStream=new ObjectInputStream(new FileInputStream(filePath))){
            return objectInputStream.readObject();
        } catch (IOException e) {
                e.printStackTrace();
                return null;
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
