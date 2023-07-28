package family_tree.model.file_handler;

import family_tree.model.tree.Group;
import family_tree.model.tree.SentientEntity;

import java.io.*;

public class ObjectFileHandler<E extends SentientEntity<E>> implements FileHandler<E>{
    private ObjectOutputStream save;
    private ObjectInputStream read;

    @Override
    public boolean save(Group<E> family, String familyName){
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
    public Group<E> read(String path) {
        try {
            read = new ObjectInputStream(new FileInputStream(path.toLowerCase() + ".out"));
            Group<E> result = (Group<E>) read.readObject();
            read.close();
            return result;
        }
        catch (IOException | ClassNotFoundException e){
            return null;
        }
    }
}
