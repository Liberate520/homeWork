package notes;

import java.io.File;
import java.io.FileWriter;

public class Saver {
    private static String FILE_PATH = "src/main/java/notes/data/data.json";

    public void save(String data) {
        try {
            File file = new File(FILE_PATH);
            if (file.createNewFile()) {
                System.out.println("File created");
            }
            FileWriter writer = new FileWriter(file);
            writer.write(data);
            writer.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
