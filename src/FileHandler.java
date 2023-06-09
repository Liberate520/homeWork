import model.humans.tree.FamilyTree;

import java.io.*;

public class FileHandler {

    SaveFile saveFile;
    WriteFile writeFile;

    public FileHandler() {
        this.saveFile = new SaveFile();
        this.writeFile = new WriteFile();
    }

    public void save(Serializable serializable) {
        saveFile.save(serializable);
    }


    public void write() {
        writeFile.write();
    }
}
