package src.model;

import java.io.IOException;
import java.io.Serializable;

public interface FileReadWrite {
	Serializable readFile(String aFileName)  throws IOException, ClassNotFoundException ;	
	String writeFile(String aFileName, Serializable aObj)  throws IOException; 
}
