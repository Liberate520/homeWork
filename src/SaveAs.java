import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class SaveAs implements Serializable {
    private Tree tree;

    public SaveAs(Tree tree) {
        this.tree = tree;
    }

    public void saveAs(Tree tree) throws IOException {
        // Сериализация в файл с помощью класса ObjectOutputStream

        ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream("tree.out"));
        objectOutputStream.writeObject(tree);
        objectOutputStream.close();

    }

    public void read() throws ClassNotFoundException, IOException {
        // Востановление из файла с помощью класса ObjectInputStream

        ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream("tree.out"));
        Tree treeRestored = (Tree) objectInputStream.readObject();
        objectInputStream.close();

        System.out.println("After Restored From Byte: " + "\n" + treeRestored.getTree());
    }
}
