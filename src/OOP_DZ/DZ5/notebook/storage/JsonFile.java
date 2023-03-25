package OOP_DZ.DZ5.notebook.storage;


import OOP_DZ.DZ5.notebook.records.RecordsList;
import OOP_DZ.DZ5.notebook.records.SimpleRecordsList;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.lang.reflect.Type;


public class JsonFile implements Storage {
    private static final Gson GSON = new GsonBuilder().setPrettyPrinting().create();

    private RecordsList recordsList;

    public JsonFile(RecordsList recordsList) {
        this.recordsList = recordsList;
    }

    @Override
    public RecordsList read() {
        String pathProject = System.getProperty("user.dir");
        String pathFile = pathProject.concat("\\src\\OOP_DZ\\DZ5\\files\\file.json");
        try (FileReader reader = new FileReader(pathFile)) {
            if (new File(pathFile).length() != 0) {
                return GSON.fromJson(reader, SimpleRecordsList.class);
            } else {
                return recordsList;
            }
        } catch (Exception e) {
            System.out.println("Parsing error " + e);
        }
        return null;
    }

    @Override
    public void write() {
        try {
            Type listType = new TypeToken<SimpleRecordsList>() {
            }.getType();
            String pathProject = System.getProperty("user.dir");
            String pathFile = pathProject.concat("\\src\\OOP_DZ\\DZ5\\files\\file.json");
            File file = new File(pathFile);
            FileWriter fileWriter = new FileWriter(file, false);
            fileWriter.write(GSON.toJson(recordsList, listType) + "\n");
            fileWriter.flush();
            fileWriter.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
