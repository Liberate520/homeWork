package family_tree;

import java.io.ByteArrayOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class WriteObj {
    //Сериализация в файл с помощью класса ObjectOutputStream
    public void WriteByObjOutput (FamilyTree tree) throws IOException {
        FileOutputStream fos = new FileOutputStream("romanovs.bin");
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(tree);
        oos.close();
    }

    //Сериализация с помощью класса ByteArrayOutputStream
    public void WriteByByteArr (FamilyTree tree) throws IOException {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(baos);
        oos.writeObject(tree);
        oos.flush();
    }
}
