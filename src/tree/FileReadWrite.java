package tree;

import java.io.*;

public class FileReadWrite implements Writable, Readable {

    @Override
    public FamilyTree readTree(String fileName) throws IOException, ClassNotFoundException {
        ObjectInputStream objectInputStream = new ObjectInputStream(
                new FileInputStream(fileName));
        FamilyTree tree = (FamilyTree) objectInputStream.readObject();
        return tree;
    }


    /**
     * Сохранение дерева в файл
     * @param tree дерево для сохранения
     * @param fileName имя файла
     * @throws IOException
     */
    @Override
    public void writeTree(FamilyTree tree, String fileName) throws IOException {
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(
                new FileOutputStream(fileName));
            objectOutputStream.writeObject(tree);
            objectOutputStream.close();
    }

}
