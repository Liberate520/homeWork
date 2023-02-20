package fileProcessing;

import java.io.IOException;
import java.util.ArrayList;

public interface Readable {
    ArrayList<String[]> read(String file_name) throws IOException;
}
