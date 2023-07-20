package Model.Write;

import Model.FamilyTree.FamilyTree;


import java.io.*;

public class WriteObjectToFile implements WriteObject {

    private ObjectOutputStream objectOutputStream = null;
    private ObjectInputStream objectInputStream = null;

    public void write(Serializable inputObject, String fileName){


        try {
            objectOutputStream = new ObjectOutputStream(
                    new FileOutputStream(fileName));
            objectOutputStream.writeObject(inputObject);
            objectOutputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public FamilyTree read(String fileName){
        FamilyTree inputElement = null;
        try {
            objectInputStream = new ObjectInputStream(
                    new FileInputStream(fileName));
            inputElement = (FamilyTree) objectInputStream.readObject();
            objectInputStream.close();

        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return inputElement;


    }
}
