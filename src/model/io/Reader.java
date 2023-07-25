package model.io;

import java.io.IOException;

public interface Reader {
    void setPathName(String pathName);
    Object loadObj() throws ClassNotFoundException, IOException;
}