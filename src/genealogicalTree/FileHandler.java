package genealogicalTree;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class FileHandler implements Writable, Readable {
    
    GenealogicalTree savingTree, tree;

    public FileHandler(GenealogicalTree savingTree) {
        this.savingTree = savingTree;
    }
    
    public FileHandler(){
    }

    @Override
    public void write() {
        //Сериализация в файл
        try{
            savingTree = new GenealogicalTree();
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream("tree.out"));
            objectOutputStream.writeObject(savingTree);
            objectOutputStream.close();
        } catch(Exception e){ e.printStackTrace();}
    }

    @Override
    public GenealogicalTree read() {
        //Восстановление из файла
        try{
            //savingTree = new GenealogicalTree<>();
            ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream("tree.out"));
            tree = (GenealogicalTree) objectInputStream.readObject();
            objectInputStream.close();
        } catch(Exception e){ e.printStackTrace();}
        return tree;
    }
}
