package model;


import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class SaveToCSV implements ISaveable {
    private File file = new File("Person.csv");
    @Override
    public void saveAs(String human){
        try {
            FileWriter writer = new FileWriter(file, false);
            writer.write(human);
            writer.close();
        } catch (IOException e) {
            // TODO Автоматически сгенерированный блок захвата
            e.printStackTrace();
        }
    }

    public File getFile() {
        return file;
    }

    public void setFile(File file) {
        this.file = file;
    }
}
