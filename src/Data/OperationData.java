package OOPjavaTree.src.Data;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class OperationData extends Data {
    @Override
    public void saveData(String data, String path, Boolean bool) {
        try(FileWriter writer = new FileWriter(path, bool))
        {
            writer.write(data);
            writer.flush();
        }
        catch(IOException ex){

            System.out.println(ex.getMessage());
        }
    }
    @Override
    public String loadData(String path) {
        StringBuilder sb = new StringBuilder();
        String inputStr;
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            while ((inputStr = br.readLine()) != null) {
                sb.append(inputStr).append(System.lineSeparator());
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        return sb.toString().replaceAll("\n", ";");
    }
    }
