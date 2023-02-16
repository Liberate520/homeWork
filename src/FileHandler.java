import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class FileHandler implements Serializable {
    private String fileName;

    public FileHandler(){
        this.fileName = "person.out";
    }

    public void fileWrite (FamilyTree family) throws IOException, ClassNotFoundException {
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(fileName));
        for (Human human: family.getFamilyTree()){
            objectOutputStream.writeObject(human);
        }
        objectOutputStream.close();
    }
    
    public void fileRead(FamilyTree family) throws IOException, ClassNotFoundException {
        ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(fileName));
        
        while (true){
            try {
                family.add((Human) objectInputStream.readObject());
            } catch (EOFException e) {
                break;
            }
        }
        objectInputStream.close();
    }
}
