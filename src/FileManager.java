package family_tree;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;


public class FileManager implements Serialise {
    String name;

    public FileManager(String name) {
        this.name = name;
    }


    @Override
    public String readInFile() throws IOException {
        try(BufferedReader fileReader = new BufferedReader(new FileReader(this.name))){
            StringBuilder result = new StringBuilder();
            String line;
            while ((line = fileReader.readLine()) !=null ){
                result.append(line);
                result.append("\n");
            }
            return new String(result);

        }catch(IOException ex){

            System.out.println(ex.getMessage());
        }
        return "";
    }


    @Override
    public void writeToFile(String dataString) throws IOException {
        try (FileWriter fileWriter = new FileWriter(this.name, false)) {
            fileWriter.write(dataString);

        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
