package familyTree.treeWorkspace;

import java.io.*;

public class TreeLoader implements Writable {
    // Класс - загрузчик деревьев
    @Override
    public void saveTree(FamilyTree tree, String path) {
        try (ObjectOutputStream objectOutputStream =
                     new ObjectOutputStream(
                             new FileOutputStream(path))) {
            objectOutputStream.writeObject(tree);
        }
        catch (IOException e){
            System.out.println("Ошибка записи: " + e);
        }
    }

    @Override
    public Object loadTree(String path) {
        try (ObjectInputStream objectInputStream =
                new ObjectInputStream(
                        new FileInputStream(path)
                )){
            return objectInputStream.readObject();
        }
        catch (IOException e){
            System.out.println("Ошибка считывания из файла:" + e);
        }
        catch (ClassNotFoundException e){
            System.out.println("Объект не распознан" + e);
        }
        return null;
    }
}
