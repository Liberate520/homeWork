import java.io.Serializable;
public interface Writable {
    boolean saveFile(Serializable serializable);
    Object loadFile();
}
