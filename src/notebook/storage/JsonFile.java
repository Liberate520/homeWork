package notebook.storage;

import notebook.RecordsList;
import notebook.Service;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

public class JsonFile implements Storage{
    private static final Gson GSON = new GsonBuilder().setPrettyPrinting().create();

    private Service service;

    public JsonFile() {
        this.service = new RecordsList();
    }

    public Service getService() {
        return service;
    }

    @Override
    public Service read() {
        String pathProject = System.getProperty("user.dir");
        String pathFile = pathProject.concat("\\src\\files\\file.json");
        try (FileReader reader = new FileReader(pathFile)) {
            if (new File(pathFile).length() != 0) {
                return GSON.fromJson(reader, RecordsList.class);
            } else {
                return new RecordsList();
            }
        } catch (Exception e) {
            System.out.println("Parsing error " + e);
        }
        return null;
    }

    @Override
    public void write(Service service) {
        try {
            String pathProject = System.getProperty("user.dir");
            String pathFile = pathProject.concat("\\src\\files\\file.json");
            File file = new File(pathFile);
            FileWriter fileWriter = new FileWriter(file, false);
            fileWriter.write(GSON.toJson(service) + "\n");
            fileWriter.flush();
            fileWriter.close();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Not on plan(((");
        }
    }
}
