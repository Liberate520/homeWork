package model;

import java.io.FileWriter;
import java.io.IOException;


public class SaveToTxt implements Saveable {

    private String path = "123.txt";
    
    @Override
    public void saveAs(String human){
        try {
            FileWriter writer = new FileWriter(path, false);
            writer.write(human);
            writer.close();
        } catch (IOException e) {
            // TODO Auto-generated catch block
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
