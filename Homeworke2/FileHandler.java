package homeWork.Homeworke2;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.io.FileOutputStream;
import java.io.FileInputStream;

public class FileHandler implements Writable, Serializable {

    private void writeObject(ObjectOutputStream obj) throws IOException {
        obj.defaultWriteObject();
    }

    private void readObject(ObjectInputStream obj) throws IOException, ClassNotFoundException {
        obj.defaultReadObject();
    }

    @Override
    public void save(FamilyTree tree) {
        try (FileOutputStream fos = new FileOutputStream("FamilyTree.out")){
            ObjectOutputStream out = new ObjectOutputStream(fos);
            out.writeObject(tree);
            out.close();
            System.out.println("Saved\n");
        } catch (Exception e) {
            System.out.println("Oops!");
        }
    }

    @Override
    public Object read() {
        try (FileInputStream fis = new FileInputStream("FamilyTree.out")){
            FamilyTree tree = new FamilyTree();
            ObjectInputStream in = new ObjectInputStream(fis);
            tree = (FamilyTree) in.readObject();
            in.close();
            System.out.println("Read\n");
            return tree;
        } catch (Exception e) {
            System.out.println("Oops!");
            return null;
        }
    }
}
