package notebook.core.mvp.models.file;

import java.io.IOException;
import java.util.List;

import notebook.core.essence.Recording;

public interface FileHandler {
    public List<Recording> read(String filePath) throws IOException;

    public void write(String filePath, Iterable<Recording> iterable) throws IOException;
}
