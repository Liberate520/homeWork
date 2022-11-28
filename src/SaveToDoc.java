import java.io.File;
import java.io.FileWriter;
import java.io.IOException;


public class SaveToDoc extends SaveTo {

    private File file = new File("321.doc");
    
    @Override
    public void saveAs(String human){
        try {
            FileWriter writer = new FileWriter(file, false);
            writer.write(human);
            writer.close();
        } catch (IOException e) {
            // TODO Auto-generated catch block
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
