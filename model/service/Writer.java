package model.service;
import java.io.Serializable;

public interface Writer {
    boolean save (Serializable serializable, String filePath);
    Object read(String filePath);
}
