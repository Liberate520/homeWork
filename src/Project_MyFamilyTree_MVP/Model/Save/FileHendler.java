package Project_MyFamilyTree_MVP;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;


public class FileHendler implements Saveable{
       

@Override
    public boolean saveMethod(Serializable serializable, String filesave) {
        try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(filesave))){
            objectOutputStream.writeObject(serializable);
            return true;
        }
        catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }
    
    @Override
    public Object readMethod(String filesave) {
        try (ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(filesave))){
            return objectInputStream.readObject();
        }
        catch (Exception e){
            e.printStackTrace();
        return null;
        }
    }
}


        
        