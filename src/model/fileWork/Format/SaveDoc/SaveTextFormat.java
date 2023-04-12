package model.fileWork.Format.SaveDoc;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class SaveTextFormat<T> implements InterfaceSave<T>
{

    @Override
    public void write(T t) throws IOException, ClassNotFoundException
     {
            String pathProject = System.getProperty("user.dir");
            String pathFile = pathProject.concat("/file.txt");
            File file = new File(pathFile);
            FileWriter writer = new FileWriter(file.getAbsolutePath(), false);
            writer.write("\nTxt Format\n");
            writer.write(t.toString()); 
            writer.flush(); 
    }
    
}
