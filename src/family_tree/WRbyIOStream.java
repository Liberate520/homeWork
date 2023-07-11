package family_tree;

import java.io.*;

public class WRbyIOStream {
    //Сериализация в файл с помощью класса ObjectOutputStream
    public void WriteObj (FamilyTree tree, String fileName) throws IOException {
        FileOutputStream fos = new FileOutputStream(fileName);
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(tree);
        oos.close();
    }

    // Десериализация  из файла с помощью класса ObjectInputStream
    public FamilyTree ReadObj (String fileName) throws IOException, ClassNotFoundException {
        FileInputStream fis = new FileInputStream(fileName);
        ObjectInputStream ois = new ObjectInputStream(fis);
        FamilyTree tree = (FamilyTree) ois.readObject();
        ois.close();
        return tree;
    }
}
