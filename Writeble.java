import java.io.Serializable;

public interface Writeble {
    boolean save(Serializable object, String filetpath);

    Object read(String filepath);
}