package Model.service.FileHandlers;

import java.io.IOException;

public interface Readable {
    Object read(String path) throws IOException, ClassNotFoundException;
}
