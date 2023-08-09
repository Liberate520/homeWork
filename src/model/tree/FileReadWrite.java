package model.tree;

import java.io.*;

public class FileReadWrite implements Writable, Readable {

    @Override
    public FamilyTree readTree() throws IOException, ClassNotFoundException {
        ObjectInputStream objectInputStream = new ObjectInputStream(
                new FileInputStream("Tree.out"));
        FamilyTree tree = (FamilyTree) objectInputStream.readObject();
        return tree;
    }


    /**
     * Сохранение дерева в файл
     * @param tree дерево для сохранения
     * @throws IOException
     */
    @Override
    public void writeTree(FamilyTree tree) throws IOException {
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(
                new FileOutputStream("Tree.out"));
            objectOutputStream.writeObject(tree);
            objectOutputStream.close();
    }

}
