package src.treeApi;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class FileHandler implements Serializable {
    
    public void outPut(FamilyTree familyTree) throws FileNotFoundException, IOException {
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(
            new FileOutputStream("file.txt"));
        objectOutputStream.writeObject(familyTree);
        objectOutputStream.close();
    }

    public FamilyTree inPut() throws FileNotFoundException, IOException, ClassNotFoundException {
        ObjectInputStream objectInputStream = new ObjectInputStream(
                new FileInputStream("file.txt"));
        FamilyTree familyRestored = (FamilyTree) objectInputStream.readObject();
        objectInputStream.close();
        return familyRestored;
    }
}
