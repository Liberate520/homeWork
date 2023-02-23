package familyApi;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class FileHandler<T extends User> implements Serializable {
    private String fileName;

    public FileHandler(String fileName){
        this.fileName = fileName;
    }

    public FileHandler(){
        this("person.out");
    }

    public void fileWrite (FamilyTree<T> family) throws IOException, ClassNotFoundException {
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(fileName));
        for (T human: family.getFamilyTree()){
            objectOutputStream.writeObject(human);
        }
        objectOutputStream.close();
    }
    
    @SuppressWarnings("unchecked")
    public void fileRead(FamilyTree<T> family) throws IOException, ClassNotFoundException {
        ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(fileName));
        
        while (true){
            try {
                family.add((T) objectInputStream.readObject());
            } catch (EOFException e) {
                break;
            }
        }
        objectInputStream.close();
    }
}
