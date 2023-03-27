package notes;

import java.io.*;

public class FileIO implements DataIO {
    private static final String FILE_PATH = "src/main/java/notes/data/data.json";

    public String getData() {
        StringBuilder sb = null;
        try (BufferedReader br = new BufferedReader(new FileReader(FILE_PATH))) {
            sb = new StringBuilder();
            String s;
            while ((s = br.readLine()) != null) {
                sb.append(s);
            }
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
        return sb.toString();
    }

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
