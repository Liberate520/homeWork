import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public interface SaveRead {
    default void saveFile(String string, String filename) {
        try (FileWriter file = new FileWriter(filename)) {
            file.append(string);

        } catch (IOException e) {
            throw new RuntimeException();
        }
    }

    default void readFile(String filename) {
        try(FileReader reader = new FileReader("file.txt"))
        {
            int c;
            while((c = reader.read()) != -1) {
                System.out.print((char)c);
            } 
        }
        catch(IOException ex){
            System.out.println(ex.getMessage());
        }   
    }
}