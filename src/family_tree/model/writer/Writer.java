package family_tree.model.writer;

import java.io.Serializable;

public interface Writer {

    boolean write(Serializable sr, String filePath);

    Object read(String filePath);

}
