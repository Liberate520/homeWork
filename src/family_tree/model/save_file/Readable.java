package family_tree.model.save_file;
import java.io.IOException;

public interface Readable<E> {
    public E readFromFile(String path) throws IOException, ClassNotFoundException;
}
