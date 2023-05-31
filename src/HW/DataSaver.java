package HW;

import java.io.*;

public class DataSaver implements UpDownLoader {
    public void saver(FamilyTree tree) throws IOException {

        //Сериализация в файл с помощью класса ObjectOutputStream
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(
                new FileOutputStream("tree.out"));
        objectOutputStream.writeObject(tree);
        objectOutputStream.close();
    }

    public FamilyTree recovery() throws IOException, ClassNotFoundException {
        // Востановление из файла с помощью класса ObjectInputStream
        ObjectInputStream objectInputStream = new ObjectInputStream(
                new FileInputStream("tree.out"));
        FamilyTree tree = (FamilyTree) objectInputStream.readObject();
        objectInputStream.close();
        return tree;
    }

}
