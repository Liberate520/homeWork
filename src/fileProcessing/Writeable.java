package fileProcessing;

import java.io.IOException;

public interface Writeable {
    void write(String file_name, String [] file, String separator) throws IOException;    
}