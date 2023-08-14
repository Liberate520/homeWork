package family_tree.model.save_file;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class FileHandler<E> implements Writable<E>, Readable<E> {

    @Override
    public boolean writeToFile(E file, String path) throws IOException{
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(path));
        objectOutputStream.writeObject(file);
        objectOutputStream.close();
        return true;
    }

    @Override
    public E readFromFile(String path) throws IOException, ClassNotFoundException {
        ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(path));
        E file = (E) objectInputStream.readObject();
        objectInputStream.close();
        return file;
    }
}
