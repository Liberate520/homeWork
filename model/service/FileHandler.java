package model.service;

import java.io.*;

//
//

public class FileHandler implements Writer{

        public boolean save (Serializable serializable, String filePath){
    try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(filePath))){
        objectOutputStream.writeObject(serializable);
        //objectOutputStream.close();
        return true;
    } catch (Exception e){
        e.printStackTrace();
        return true;
    }
}

        public Object read (String filePath){
    try (ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(filePath))){
        return objectInputStream.readObject();
    } catch (Exception e){
        //objectInputStream.close();
        return null;
    }
}
}
