package genealogicalTree;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import package1.*;

public class FileHandler implements Writable {
    
    GenealogicalTree savingTree;

    public FileHandler(GenealogicalTree savingTree) {
        this.savingTree = savingTree;
    }
    
    @Override
    public void write() {
        // //Сериализация в файл
        // ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream("tree.out"));
        // objectOutputStream.writeObject(savingTree);
        // objectOutputStream.close();
    }

    // public GenealogicalTree read(String file){
    //     //Восстановление из файла
    //     ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream("tree.out"));
    //     GenealogicalTree myTree = (GenealogicalTree) objectInputStream.readObject();
    //     objectInputStream.close();
    //     return myTree;
    // }
}
