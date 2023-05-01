package OutAndInputInfo;

import FamilyTreeObject.FamilyTreeObject;
import FamilyTreeObject.Humans.Human;

import java.io.*;

public class OutAndInputInfo implements Serializable{

    private ObjectOutputStream objectOutputStream = null;
    private ObjectInputStream objectInputStream = null;

    public void WriteInfo(Serializable inputObject, String fileName){


        try {
            objectOutputStream = new ObjectOutputStream(
                    new FileOutputStream(fileName));
            objectOutputStream.writeObject(inputObject);
            objectOutputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public FamilyTreeObject ReadInfo(String name){
        FamilyTreeObject inputElement = null;
        try {
            objectInputStream = new ObjectInputStream(
                    new FileInputStream(name));
            inputElement = (FamilyTreeObject) objectInputStream.readObject();
            objectInputStream.close();

        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return inputElement;


    }
}
