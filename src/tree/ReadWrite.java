package tree;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class ReadWrite implements ReadWriteable {
 
    @Override
    public FamilyTree read() {
        FamilyTree tree = null;
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("homeWork/src/tree/tree.out"))){
            tree = (FamilyTree) ois.readObject();
            ois.close();
        }
        catch (Exception ex){
            System.out.println(ex.getMessage());
        }
        return tree;
    }

    @Override
    public void write(FamilyTree tree) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("homeWork/src/tree/tree.out", false))){
            oos.writeObject(tree);
            oos.close();
        }
        catch (Exception ex){
            System.out.println(ex.getMessage());
        }
    }
}
