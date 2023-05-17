package java_oop_homeWork.src.model.serialization;

import java.io.Serializable;

public interface Writeble {
    boolean write(Serializable serializable, String filePath);
    Object read(String filePath);
}
