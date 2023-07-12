package familytree.file_hendler;
import java.io.Serializable;

public interface Writeble {
    boolean write(Serializable serializable, String filePath);
    Object read(String filePath);
}
