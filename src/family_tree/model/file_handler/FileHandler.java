package family_tree.model.file_handler;

import family_tree.model.tree.Entity;
import family_tree.model.tree.Tree;

import java.io.*;
import java.util.Locale;

public class FileHandler implements Saveable, Readable{
    private ObjectOutputStream save;
    private ObjectInputStream read;

    @Override
    public boolean save(Tree family, String familyName){
        try {
            save = new ObjectOutputStream(new FileOutputStream(familyName.toLowerCase() + ".out"));
            save.writeObject(family);
            save.close();
            return true;
        }
        catch (IOException e){
            return false;
        }
    }

    @Override
    public Tree read(String path) {
        try {
            read = new ObjectInputStream(new FileInputStream(path.toLowerCase() + ".out"));
            Tree result = (Tree) read.readObject();
            read.close();
            return result;
        }
        catch (IOException | ClassNotFoundException e){
            return null;
        }
    }
}
