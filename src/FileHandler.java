
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class FileHandler implements Savable{

    @Override
    public void save(Serializable serializable) throws FileNotFoundException, IOException {
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream("FamilyTree.out"));
        objectOutputStream.writeObject(serializable);
        objectOutputStream.close();
    }

    @Override
    public FamilyTree download() throws FileNotFoundException, IOException, ClassNotFoundException {
        ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream("FamilyTree.out"));
        FamilyTree FamilyTree = (FamilyTree) objectInputStream.readObject();
        objectInputStream.close();
        return FamilyTree;
    }

    // @Override
    // public void write() { // Написать функцию записи в файла, например, csv

    // }

    // @Override 
    // public Object read() { // Написать функцию чтения из файла, например, csv
    //     return null;
    // }

}
