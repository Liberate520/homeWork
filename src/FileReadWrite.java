import java.io.Serializable;
import java.io.IOException;

public interface FileReadWrite{
	Serializable readFile(String aFileName)  throws IOException, ClassNotFoundException ;	
	String writeFile(String aFileName, Serializable aObj)  throws IOException; 
}