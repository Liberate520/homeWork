package Package.WorkWithFiles;

import java.io.IOException;

public interface Filable {

    void writeObj(Object obj, String name) throws IOException;

    void readObj(String name) throws IOException, ClassNotFoundException;
}
