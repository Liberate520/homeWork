package model.fileProcessing;

import java.io.IOException;

public interface Writeable {
    /**
     * @param file_name - имя файла
     * @param file - файл который необходимо записать, в виде списка (1 линия информация про 1 человека)
     * @param separator - разделитель в файле
     * @throws IOException
     */
    void write(String file_name, String [] file, String separator) throws IOException;    
}