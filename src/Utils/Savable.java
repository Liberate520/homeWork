package Utils;

import java.io.Serializable;

public interface Savable {
    boolean writeTree(Serializable serializable, String fileName);
    Object restoreTree(String fileName);
}
