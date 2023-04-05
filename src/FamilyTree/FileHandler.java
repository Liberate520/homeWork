package FamilyTree;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class FileHandler {
    
    
    public void saveData(Saveble s, String path) throws IOException, ClassNotFoundException {//saveData
        FileOutputStream fos = new FileOutputStream(path);//"tree.save"
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(s);
        System.out.println("Файл успешно записан");
        oos.close();
    }
    
    public void saveTree(Serializable o) throws IOException, ClassNotFoundException {//saveData
        FileOutputStream fos = new FileOutputStream("tree.save");
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(o);
        System.out.println("Файл успешно записан");
        oos.close();
    }

    public Object loadData() throws IOException, ClassNotFoundException{
        FileInputStream fis = new FileInputStream("tree.save");
        ObjectInputStream ois = new ObjectInputStream(fis);
        Object o = ois.readObject();
        System.out.println("Поцедура загрузки завершена успешно");
        ois.close();
        return o;
    }

    public Tree loadTree(String path) throws IOException, ClassNotFoundException{
        FileInputStream fis = new FileInputStream(path);
        ObjectInputStream ois = new ObjectInputStream(fis);
        Tree t = (Tree) ois.readObject();
        System.out.println("Поцедура загрузки завершена успешно");
        ois.close();
        return t;
    }

}
