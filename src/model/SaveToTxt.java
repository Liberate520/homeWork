package model;


import java.io.FileWriter;
import java.io.IOException;
public class SaveToTxt implements ISaveable {
    private String path = "Person.txt";
    
    @Override
    public void saveAs(String human){
        try {
            FileWriter writer = new FileWriter(path, true);
            writer.write(human);
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
