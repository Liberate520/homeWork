package family_tree.model.save_file;
import java.io.IOException;

public interface Writable<E> {
    public boolean writeToFile(E file, String path) throws IOException;
}
