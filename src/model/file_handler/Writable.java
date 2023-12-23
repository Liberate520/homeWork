package model.file_handler;
import java.io.Serializable;

public interface Writable{
    boolean save(Serializable serializable);
    Object read(String filePath);
}