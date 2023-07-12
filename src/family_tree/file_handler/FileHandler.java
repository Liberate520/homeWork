package family_tree.file_handler;

import family_tree.tree.Tree;

import java.io.*;

public class FileHandler implements Saveable, Readable{
    private ObjectOutputStream save;
    private ObjectInputStream read;

    @Override
    public void save(Tree family, String familyName){
        try {
            save = new ObjectOutputStream(new FileOutputStream(familyName + ".out"));
            save.writeObject(family);
            save.close();
        }
        catch (IOException e){
            System.out.println("Файл не найден");
        }
    }

    @Override
    public Tree read(String path) {
        try {
            read = new ObjectInputStream(new FileInputStream(path));
            Tree result = (Tree) read.readObject();
            read.close();
            return result;
        }
        catch (IOException e){
            System.out.println("Файл не найден");
            return null;
        } catch (ClassNotFoundException e) {
            System.out.println("Класс не найден");
            return null;
        }
    }
}
