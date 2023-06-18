package Models.Repositories;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class BinaryKeeper<T extends Serializable> implements Keeper<T>{

    private String path;
    public BinaryKeeper(String path){
        this.path = path;
    }
   
    @Override
    public T read() {
        try {
            ObjectInputStream stream = new ObjectInputStream(new FileInputStream(path));
            T object = (T)stream.readObject();
            stream.close();
            return object;
        } catch (Exception e) {
            System.err.println(e.getMessage());
            return null;
        }
    }

    @Override
    public boolean save(T object) {
        try (ObjectOutputStream stream = new ObjectOutputStream(new FileOutputStream(path))) {
            stream.writeObject(object);
            stream.flush();
            return true;
        } catch (Exception e) {
            System.err.println(e.getMessage());
            return false;
        }
    }
    
}
