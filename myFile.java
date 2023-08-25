import java.io.*;
import java.util.*;

public class myFile implements my_File{
    private File file = new File("FamilyList.txt");
    public myFile(File f){
        this.file = f;
    }
    Scanner scanner;
    String[] params;

    public Scanner file() throws IOException{
        scanner = new Scanner(file);
        while(scanner.hasNextLine()){
            return scanner;
        }
        return null;
    }

    public String[] read(){
        while(scanner.hasNextLine()){
            params = scanner.nextLine().split(", ");
            return params;
        }
        return null;
    }
    
    public void write(Person human){
        
    }
    
    
}

interface my_File {
    Scanner file() throws IOException;
    String[] read();
    void write(Person human);
}
