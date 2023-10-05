package fileHandler;

import familyTree.FamilyTree;
import java.io.*;


public class FileHandler {

    public boolean save(Serializable ser,String path){
        try{ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(path));
            oos.writeObject(ser);
            return true;
        } catch (IOException e){
            e.printStackTrace();
            return false;
        }
    }

    public Object read(String path){
        try{ObjectInputStream ois = new ObjectInputStream(new FileInputStream(path));
            return ois.readObject();
        } catch (Exception i){
            i.printStackTrace();
            return null;
        }
    }
}
