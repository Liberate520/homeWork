package FamTree;
 import java.io.Serializable;
public interface Load {
    boolean save(Serializable serializable, String path);
    Object load(String path);
}
