package FileHandler;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class FileHandler implements Writeable{
    public boolean save(Serializable serializable,String path){
        try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(path))){
            oos.writeObject(serializable);
            return true;
        }
        catch(Exception exception){
            exception.printStackTrace();
            return false;
        }
    }

    public Object load(String path){
        try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream(path))){
            return ois.readObject();
        }
        catch(Exception ex){
            ex.printStackTrace();
            return null;
        }
    }
}
