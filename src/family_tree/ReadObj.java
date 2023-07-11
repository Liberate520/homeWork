package family_tree;

import java.io.*;

public class ReadObj {
    // Десериализация  из файла с помощью класса ObjectInputStream
    public FamilyTree ReadByObjOutput (FamilyTree tree) throws IOException, ClassNotFoundException {
        FileInputStream fis = new FileInputStream("romanovs.bin");
        ObjectInputStream ois = new ObjectInputStream(fis);
        tree = (FamilyTree) ois.readObject();
        ois.close();
        return tree;
    }

    // Десериализация с помощью класса ByteArrayInputStream
    public FamilyTree ReadByByteArr (FamilyTree tree, ByteArrayOutputStream baos) throws IOException, ClassNotFoundException {
        ByteArrayInputStream bais = new ByteArrayInputStream(baos.toByteArray());
        ObjectInputStream ois = new ObjectInputStream(bais);
        tree = (FamilyTree) ois.readObject();
        ois.close();
        return tree;
    }
}
