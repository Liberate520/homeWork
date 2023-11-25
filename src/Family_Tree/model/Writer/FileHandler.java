package Family_Tree.model.Writer;

import Family_Tree.model.Tree.FamilyTreeIterator;

import java.io.*;

public class FileHandler <Human> implements Writable{

    public boolean save(Serializable serializable, String filePath){
        try(ObjectOutputStream objectOutputStream=new ObjectOutputStream(new FileOutputStream(filePath))){
            objectOutputStream.writeObject(serializable);
            return true;
        } catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

    public Object read(String filePath){
        try (ObjectInputStream objectInputStream=new ObjectInputStream(new FileInputStream(filePath))){
            return objectInputStream.readObject();
        } catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }
}
