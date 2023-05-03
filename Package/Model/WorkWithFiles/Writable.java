package Package.Model.WorkWithFiles;

import java.io.IOException;

public interface Writable {
    void writeObj(Object obj) throws IOException;
}
