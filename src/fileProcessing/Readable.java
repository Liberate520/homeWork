package fileProcessing;

import java.io.IOException;
import java.util.ArrayList;

public interface Readable {
    /**
     * @param file_name - имя файла
     * @return вовращает список людей из файла (по строчно)
     * @throws IOException
     */
    ArrayList<String[]> read(String file_name) throws IOException;
}
