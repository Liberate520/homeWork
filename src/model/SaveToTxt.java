package model;

import java.io.FileWriter;
import java.io.IOException;


@SuppressWarnings("ALL")
public class SaveToTxt implements ISaveable {

    private String path = "Person.txt";
    
    @Override
    public void saveAs(String person){
        try {
            FileWriter writer = new FileWriter(path, false);
            writer.write(person);
            writer.close();
        } catch (IOException e) {
            // TODO Автоматически сгенерированный блок захвата
            e.printStackTrace();
        }
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }
}
