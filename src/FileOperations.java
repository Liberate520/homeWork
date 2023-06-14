import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.io.Serializable;

public interface FileOperations  {
    void writeExternal(Human human, String filePath) throws IOException;

    Human readExternal(String filePath) throws IOException, ClassNotFoundException;
}
