import java.io.*;
import java.util.*;

public class MyFile implements I_MyFile{
    private File file = new File("FamilyList.txt");
    public MyFile(File f){
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
